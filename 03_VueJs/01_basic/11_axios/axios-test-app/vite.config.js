import { fileURLToPath, URL } from 'node:url';

import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';
import vueDevTools from 'vite-plugin-vue-devtools';

// https://vite.dev/config/
export default defineConfig({
  plugins: [vue(), vueDevTools()],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
    },
  },

  // 프록시 설정
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:3000', //실제 API 서버 주소
        changeOrigin: true, // 원본 서버 주소를 변경하지 않고 프록시 서버 주소로 변경

        // 프록시 서버 주소 변경
        rewrite: (path) => path.replace(/^\/api/, ''),
        // -> /api를 ''(빈문자열)로 대체
      },
    },
  },
});
