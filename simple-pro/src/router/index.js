import Vue from 'vue'
import Router from 'vue-router'
import login from '../views/login/index'
import home from '../views/home/index'
import studentManage from "../views/student/studentManage";
import user from '../views/user/userManage'
import NProgress from 'nprogress' // Progress 进度条
import 'nprogress/nprogress.css'// Progress 进度条样式
import { getToken } from '../utils/auth' // 验权
import userManage from "../views/user/userManage";
import store from "../store";
import { Message } from 'element-ui'
import {getUserRolePermission} from '../utils/api'
import {getUserId} from '../utils/auth'
Vue.use(Router)

export const constantRouterMap = [
  // {path: '/regist', component: () => import('@/views/login/regist'), hidden: true},
  // {path: '/login', component: () => import('@/views/login/index'), hidden: true},
  // {path: '/404', component: () => import('@/views/404'), hidden: true},
  // {path: '/logisticsList', component: () => import('@/views/logistics/ShowOrders'), hidden: true},
  // {path: '/imServer', component: () => import('../components/im/imServer'), hidden: true}
  {
    path: '/',
    name: 'login',
    component: login
  },
  {
    path: '/login',
    name: 'login',
    component: login
  },
  {
    path: '/home',
    name: 'home',
    component: () => import(`../views/home/index`),
    children: []
  }
  // {
  //   path: '/studentManage',
  //   name: 'studentManage',
  //   component: studentManage
  // },
  // {
  //   path: '/userManage',
  //   name: 'userManage',
  //   component: userManage
  // }
];

// const router = new Router({
//   routes: constantRouterMap
//   }
// );

// 定义一个函数来创建router
const router = new Router({
  mode: 'history',
  base: process.env.API_BASEURL, //从环境进程中根据运行环境获取的api的base_url
  routes: constantRouterMap
});

export function generateRoutes(menus = []) {
    store.dispatch('loadRoutes').then();
    for(let i = 0, l = menus.length; i < l; i++){
        menus[i].children.forEach(menuItem => {
          let menu = {
            path: menuItem.path,
            name: menuItem.name,
            // component: (resolve) => require([`@/views/${menuItem.component}`], resolve),
            component: () => import(`../views/${menuItem.component}`),
            meta: {
              icon:menuItem.icon,
              title:menuItem.name
            }
          };
          // constantRouterMap.push(menu);
          constantRouterMap[2].children.push(menu);
        })
    }
    return constantRouterMap;
}

const whiteList = ['/login','/regist','/logisticsList','/logistics'] // 不重定向白名单
router.beforeEach((to, from, next) => {
  NProgress.start();
  if (getToken()) {
    //防止刷新导致的动态路由失效，isLoadRoutes用于判断是否失效
    if(!store.getters.isLoadRoutes){
      let permissions = localStorage.getItem("permissions");
      if(permissions !== null){
        permissions = JSON.parse(permissions);
        store.commit('SET_PERMISSIONS',permissions);
        store.commit('SET_LOAD_ROUTES');
        let routes = generateRoutes(permissions);
        router.addRoutes(routes);
        router.options.routes.push(routes);
        next();
      }else{
        let userId = getUserId();
        getUserRolePermission(userId).then(res =>{
          if(typeof(res.data) == "undefined" || res.data == null){
            next({ path: '/login' });
            return;
          }
          permissions = res.data;
          localStorage.setItem("permissions",JSON.stringify(res.data));
          store.commit('SET_PERMISSIONS',permissions);
          store.commit('SET_LOAD_ROUTES');
          let routes = generateRoutes(permissions);
          router.addRoutes(routes);
          router.options.routes.push(routes);
          next();
        }).catch((err) => {
          store.dispatch('frontEndLoginOut').then(() => {
            Message.error(err || 'Verification failed, please login again');
            localStorage.clear();
            next({ path: '/login' })
          })
        });
      }
    }else{
      next();
    }
  } else {
    if (whiteList.indexOf(to.path) !== -1) {
      next()
    } else {
      next('/login');
      NProgress.done()
    }
  }
});

router.afterEach(() => {
  NProgress.done() // 结束Progress
});

export default router;


