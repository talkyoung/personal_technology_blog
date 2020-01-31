import axios from "axios";
import {getToken} from "./auth"
import { Message } from 'element-ui'
import store from '../store'

const service = axios.create({
  baseURL: process.env.API_BASEURL, // 从环境进程中根据运行环境获取的api的base_url,  // api的base_url
  timeout: 5000  // 请求超时时间
});

service.interceptors.request.use(config => {
  if (store.getters.token) {
    config.headers['Authorization'] = getToken() // 让每个请求携带自定义token 请根据实际情况自行修改
  }
  return config;
}, error => {  //请求错误处理
  Promise.reject(error)
});

/****** respone拦截器==>对响应做处理 ******/
service.interceptors.response.use(
  response => {
    /**
     * code为非200是抛错 可结合自己业务进行修改
     */
    const res = response.data
    if (res.code !== 200) {
      Message({
        message: res.message,
        type: 'error',
        duration: 3 * 1000
      })

      // 401:未登录;
      // if (res.code === 401||res.code === 403) {
      //   MessageBox.confirm('你已被登出，可以取消继续留在该页面，或者重新登录', '确定登出', {
      //     confirmButtonText: '重新登录',
      //     cancelButtonText: '取消',
      //     type: 'warning'
      //   }).then(() => {
      //     store.dispatch('FedLogOut').then(() => {
      //       location.reload()// 为了重新实例化vue-router对象 避免bug
      //     })
      //   })
      // }
      return Promise.reject(res)
    } else {
      return response.data
    }
  },
  error => {  //响应错误处理
    console.log('err' + error)// for debug
    Message({
      message: error.message,
      type: 'error',
      duration: 3 * 1000
    })
    return Promise.reject(error)
  }
);

export default service;
