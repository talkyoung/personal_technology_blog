<template>
  <div :style="loginClass">
    <el-card class="login-form-layout">
        <login-header/>
        <el-form ref="loginForm" :model="loginForm" :rules="loginRules" label-width="80px">
          <el-form-item label="账号:" prop="username" style="padding-top: 20px;font-weight: bolder">
            <el-input v-model="loginForm.username" type="text" prefix-icon="el-icon-user-solid" />
          </el-form-item>
          <el-form-item label="密码:" prop="password" style="font-weight: bolder">
            <el-input v-model="loginForm.password" :type="pwdType" prefix-icon="el-icon-more"/>
          </el-form-item>
          <el-form-item style="padding-top: 10px">
            <el-button type="primary" v-on:click="login" style="width: 94.14px">Login</el-button>
            <el-button type="primary" v-on:click="hello" style="margin-left: 30px">Register</el-button>
          </el-form-item>
        </el-form>
        <login-footer/>
    </el-card>
  </div>
</template>

<script>
  import loginFooter from './LoginFooter'
  import loginHeader from './LoginHeader'
  import {hello,getUserRolePermission} from '../../utils/api'
  import {setToken, getToken, setUserId,removeToken,removeUserId} from '../../utils/auth'
  import { mapActions, mapGetters } from 'vuex'
  import {fieldIsNull,menuRender} from '../../common/js/public'
  import {constantRouterMap,createRouter} from '../../router/index'
  import {store,router} from '../../main'
  import {generateRoutes} from '../../router/index'
  export default {
    name: 'login',
    components: { loginFooter, loginHeader },
    data () {
        const validateUsername = (rule, value, callback) => {
            if (value.match(/^\s+$/) || value === '') {
                callback(new Error("请输入账号名称"))
            } else {
                callback()
            }
        };
        return {
          loginClass:{
              position: "absolute",
              width: "100%",
              height: "100%",
              overflow:"hidden",
              /*background-image: url("../../assets/login_background_image.jpg");*/
              backgroundSize: "100% 100%",
              backgroundImage: "url(" + require("../../assets/login_background_image.jpg") + ")"
            },
            loginForm: { username: '', password: '' },
            pwdType: 'password',
            loginRules: {
                username: [{required: true, trigger: 'blur', validator: validateUsername}],
                password: [{required: true, trigger: 'blur', message: "请输入密码"}]
            },
        }
    },
    methods: {
      showPwd() {
        if (this.pwdType === 'password') {
          this.pwdType = ''
        } else {
          this.pwdType = 'password'
        }
      },
      login () {
          let menu = [];
          this.$refs.loginForm.validate(valid => {
              if(valid){
                  removeToken();
                  removeToken();
                  // localStorage.clear();
                  store.dispatch('Login', this.loginForm).then(() => {
                      getUserRolePermission(this.userId).then(res =>{
                          if(typeof(res.data) == "undefined" || res.data == null){
                              return
                          }
                          menu = res.data;
                          localStorage.setItem("permissions",JSON.stringify(res.data));
                          store.commit('SET_PERMISSIONS',menu);
                          store.commit('SET_LOAD_ROUTES');
                          let routes = generateRoutes(menu);
                          this.$router.addRoutes(routes);
                          this.$router.options.routes.push(routes);
                      });
                      this.$router.push({path: '/home'})
                  }).catch(() => {
                  })
              }else{
                  console.log('参数验证不合法！');
                  return false
              }
          });
      },
      // login () {
      //     debugger;
      //     let menu = [];
      //     this.$refs.loginForm.validate(valid => {
      //         if(valid){
      //             removeToken();
      //             removeToken();
      //             // localStorage.clear();
      //             store.dispatch('Login', this.loginForm).then(() => {
      //               getUserRolePermission(this.userId).then(res =>{
      //                     if(fieldIsNull(res.data )){
      //                           return
      //                     }
      //                     res.data.forEach(menuItem =>{
      //                             menu.push(menuRender(menuItem))
      //                     });
      //                     console.log('menu:'+JSON.stringify(menu));
      //                     localStorage.setItem("permission",JSON.stringify(res.data));
      //                     this.appendMenu(Object.assign(menu));
      //                     console.log('menu1:'+JSON.stringify(menu));
      //                     this.$router.addRoutes(menu);
      //                     this.$router.options.routes.push( ...menu);
      //                     // console.log('this.$router.options.routes:'+JSON.stringify(this.$router.options.routes));
      //                     // console.log('this.$router.options.routes:'+this.$router.options.routes);
      //                     // console.log('router.options.routes:'+JSON.stringify(router.options.routes));
      //                     // console.log('router.options.routes:'+router.options.routes);
      //                     // location.reload();
      //                 });
      //               this.$router.push({path: '/home'})
      //             }).catch(() => {
      //                 this.loading = false
      //             })
      //         }else{
      //             console.log('参数验证不合法！');
      //             return false
      //         }
      //     });
      // },
      hello(){
        hello().then(resp => {
          console.log(resp)
        });
      },
        ...mapActions([
            'setToken',
            'setUserId',
            'appendMenu',
            'loadRoutes',
        ]),
    },
    computed: {
      ...mapGetters([
        'userId',
        'token',
        'isLoadRoutes'
      ]),
    },
  }
</script>

<style scoped>
  .el-button{
    font-size: 15px;
    font-weight: bold;
    /*background-color: rgba(	105,105,105, 0.5);*/
    border: none;
  }
  .login-form-layout {
    text-align: center;
    position: absolute;
    top: 200px;
    left: 0;
    right: 0;
    width: 450px;
    height: 350px;
    margin: auto;
    background-color: rgba(255, 255, 255, 0.15);
    border: none;
  }
</style>
