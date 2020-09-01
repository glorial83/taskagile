import Vue from "vue";
import VueRouter from "vue-router";
import LoginPage from "@/views/LoginPage.vue";
Vue.use(VueRouter);

const routes = [
  {
    name: "LoginPage",
    path: "/login",
    //component: () => import("@/views/LoginPage.vue")
    component: LoginPage
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
