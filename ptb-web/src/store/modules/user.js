import { getToken,getUserId,setToken,setUserId,removeToken,removeUserId} from '../../utils/auth'
import lazyLoading from "./menu/lazyLoading";
import {login} from "../../utils/api";

const user = {
  state: {
    userId:getUserId(),
    token:getToken(),
    permissions:[],
    isLoadRoutes: false,
  },

  mutations: {
    SET_TOKEN: (state, token) => {
      state.token = token
    },
    SET_USER_ID: (state, userId) => {
      state.userId = userId
    },
    SET_LOAD_ROUTES: (state)=>{
      state.isLoadRoutes = true
    },
    SET_PERMISSIONS: (state,permissions)=>{
      state.permissions = permissions
    }
  },

  actions: {
    Login({ commit }, userInfo){
      return new Promise((resolve, reject) => {
        login({username: userInfo.username, password: userInfo.password})
          .then(response => {
          const data = response.data;
          const tokenStr = data.tokenHead + data.token;
          setToken(tokenStr);
          setUserId(data.userId);
          commit('SET_TOKEN', tokenStr);
          commit('SET_USER_ID', data.userId);
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },
    setToken ({ commit }, token) {
      if (token) {
        commit("SET_TOKEN", token)
      }
    },
    setUserId({commit},userId){
      if(userId){
        commit("SET_USER_ID", userId)
      }
    },
    loadRoutes ({ commit }){
      commit('SET_LOAD_ROUTES')
    },
    appendMenu ({ commit }, menuItem) {
      if (menuItem) {
        commit("APPEND_MENU", menuItem)
      }
    },
    //前端注销
    frontEndLoginOut({commit}){
      removeToken();
      removeUserId();
      commit('SET_TOKEN','');
      commit('SET_USER_ID','');
      localStorage.clear();
    }
  }
};

export default user
