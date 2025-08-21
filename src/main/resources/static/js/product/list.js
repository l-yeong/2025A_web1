console.log('list.js exe')

let productList =[];

const getList = async() => {
    //fetch
    const response = await fetch('/product/list');
    const data = await response.json();
    console.log(data);
    //전역변수로 제품 정보 저장
    productList =data;
}//func end


//[2]카카오지도(),(마크클러스터)
const getMap = async( ) => {

    
//********************************* 현재 사용자의 위치 좌표 가져오기 *******************************//
const position = await myPosition(); // js/kakao/position.js 파일의 함수 호출

        //1. 지도 생성
        var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center: new kakao.maps.LatLng(position.coords.latitude , position.coords.longitude), // 지도의 중심좌표
        level : 6 // 지도의 확대 레벨
    });

    //2. 마커 클러스터 생성 합니다.
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 10, // 클러스터 할 최소 지도 레벨
        disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
    });
    //3. 전역변수에 있는 제품리스트 를 마커로 생성
    let markers = productList.map((product) =>{
        // 3-1 마커 생성
        let marker = new kakao.maps.Marker({position: new kakao.maps.LatLng(product.plat,product.plng)});
        // 3-2 마커 클릭 이벤트
        kakao.maps.event.addListener(marker, 'click', ()=> {
      // 마커 위에 인포윈도우를 표시합니다
      alert(`클릭한 제품명은:${product.pname}`);

      //************* 업로드된 이미지 출력 *****************
      //1. 어디에
      const productDiv = document.querySelector('#productDiv');
      //2. 무엇을 , JSP(webapp 이하), css/js/img 등등(static 이하)
      let html =``;

            //* 이미지가 없는 경우
            if(product.images.length==0){
                html += `<img src="/upload/default.png"/>`
            }else{
            //* 이미지 다수일때 반복문을 이용한 여러개 img 마크업 만들기
            for(let i=0; i<product.images.length; i++){
                let img = product.images[i];
                html +=`<img src ="/upload/${img}"/>`
            }//for end
        }//if end

      //출력
      productDiv.innerHTML=html;

        });
        //3-3 마커 반환
        return marker;
    });
    //3-4: 반복문 끝나고ㅓ 마커들을 클러스터에 넣기
    clusterer.addMarkers(markers);

    //4. 마커클러스터 클릭이벤트를 등록 합니다.
    kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {

        // 현재 지도 레벨에서 1레벨 확대한 레벨
        var level = map.getLevel()-1;

        // 지도를 클릭된 클러스터의 마커의 위치를 기준으로 확대합니다
        map.setLevel(level, {anchor: cluster.getCenter()});
    });
}//func end

const _init = async()=>{
    await getList(); //카카오맵이 실행되기전에 제품정보 가져오기 먼저 실행
    await getMap();
}//func end
_init();

    // //3. 전역변수에 있는 제품리스트를 마커로 생성
    //     //3-1 : map 반복문을 이용한 전역변수의 제품리스트 반복하기
    //     let markerList=[]; //여러개 마커들 저장하는 배열
    //     for(let i=0; i<productList.length; i++){
    //        const product = productList[i] //3-2 : 제품리스트에서 i번째 제품객체 반환

    //        //3-3:카카오api 마커 객체 생성
    //         // new kakao.maps.Marker({posotion: new kakao.maps.LatLng(위도,경도)});
    //         let marker = new kakao.maps.Marker({posotion: new kakao.maps.LatLng(product.plat,product.plng)});
    //         //3-4 : 마커들을 저장하는 마커리스트에 .push
    //         markerList.push(marker);
    //     }//for end
    // //3-5 : 반복문이 끝나고 마커들을 클러스터에 넣기
    // clusterer.addMarkers(markerList);