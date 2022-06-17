import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import TextTable from "@/views/TextTable";
import AddText from "@/views/AddText";
import TextManagement from "@/views/TextManagement";
import Echarts from "@/views/echartstext";
import NERTest from "@/views/NERTest";
import KGTest from "@/views/KGTest";
import SwiperTest from "@/views/swiper-test"
import TextTable2 from "@/views/TextTable2";
import textShow from "@/views/textShow";
import KnowQuestion from "@/views/KnowQuestion";
import admin from "@/views/admin";
import TextTable3 from "@/views/TextTable3";
import chart_test from "@/views/chart_test";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    // redirect: '/swiper',
    component: SwiperTest
  },
  {
    path: '/chart',
    name: 'chart_test',
    component: chart_test
  },
  {
    path: '/zhongbaotable',
    component: TextTable
  },
  {
    path: '/texttable3',
    component: TextTable3
  },
  {
    path: '/adminselect',
    name: 'admin',
    component: admin
  },
  {
    path: '/knowquestion',
    name: 'KnowQuestion',
    component: KnowQuestion
  },
  {
    path: '/textshow',
    name: 'textShow',
    component: textShow,
  },
  {
    path: '/shouye',
    name: 'shouye',
    component: SwiperTest
  },
  {
    path: '/swiper',
    name: 'Swiper',
    component: SwiperTest
  },
  {
    path: '/kgtest',
    name: 'KGTest',
    component: KGTest
  },
  {
    path: '/ner',
    name: 'NERTest',
    component: NERTest
  },
  {
    path: '/echarts',
    name: 'Echarts',
    component: Echarts
  },
  {
    path: '/textmanage',
    name: 'TextManagement',
    component: TextManagement
  },
  {
    path: '/addtext',
    name: 'AddText',
    component: AddText
  },
  {
    path: '/table',
    name: 'TextTable',
    component: TextTable2
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
