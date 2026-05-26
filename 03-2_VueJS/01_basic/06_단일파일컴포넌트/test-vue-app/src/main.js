// 시작 진입점(Entry Point) : 프로그램이 처음 실행되는 시작 파일

import { createApp } from 'vue'; // Vue에서 앱을 만들 수 있는 함수 가져오기
// import App from './App.vue'; // 기본 컴포넌트 사용
// import App from './App2.vue'; // 객체를 이용한 props 전달
import App from './App3.vue';

createApp(App).mount('#app');

//-----------------------------------------------------------------
/* [1] App.vue 컴포넌트를 가져옴
.vue 파일 :
- vue 컴포넌트 파일
- 한 파일에 컴포넌트 정의, 템플릿, 스크립트, 스타일을 작성
- 컴포넌트 관심사를 분리하기 위해 사용
  (.html 파일에 다 작성 x)
 */

/* [2]컴포넌트 등록
- 애플리케이션 인스턴스에 .component(사용할태그명, 컴포넌트객체) 메서드를 사용하여 등록
- 컴포넌트 사용을 위해선 등록이 필요함

1) 전역 컴포넌트 등록
- 모든 컴포넌트에서 사용 가능
- main.js에서 등록

2) 지역 컴포넌트 등록
- 특정 컴포넌트에서만 사용 가능
- 사용하려는 컴포넌트 내에서 매번 등록
*/

/* [3] 전역 컴포넌트 등록 방법 
// import CheckboxItem from './components/CheckboxItem.vue';


// createApp 함수를 호출하여 App 컴포넌트를 마운트
// - .component(사용할태그명, 컴포넌트객체) 메서드를 사용하여 등록
//createApp(App).component('CheckboxItem', CheckboxItem).mount('#app');
*/

/* 지역 컴포넌트 등록  - 지역에서 등록된 컴포넌트 사용*/
// createApp(App).mount('#app');
//-----------------------------------------------------------------
