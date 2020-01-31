<template>
  <div>
    <el-container >
      <el-aside :width="asWidth">
        <Aside :isCollapse="isCollapse" />
      </el-aside>
      <el-container>
        <el-header>
          <el-row>
            <el-col :span="12" style="text-align: center">
<!--              <el-button type="primary" class="el-icon-s-fold" @click="showMenu"></el-button>-->
              <h1>欢迎来到首页</h1>
            </el-col>
            <el-col :span="12">
              <el-button @click="logout" style="width: 77px;text-align: center;float: right" type="danger">注销</el-button>
            </el-col>
          </el-row>
        </el-header>
        <el-main>
          <router-view />
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
    import studentManage from "../student/studentManage";
    import store from "../../store";
    import Aside from "./Aside";
    export default {
      name: "home",
      components: { studentManage,Aside },
        data(){
          return {
              isCollapse: false,
              asWidth: "240px"
          }
        },
        methods:{
            toStudentManage(){
                this.$router.push({path:'/studentManage'});
            },
            toUserManage(){
                this.$router.push({path:'/userManage'});
            },
            showMenu() {
                this.isCollapse = !this.isCollapse;
            },
            logout() {
                store.dispatch('frontEndLoginOut');
                this.$router.push({path:'/login'});
            }
        },
        computed:{
        }
    }
</script>

<style scoped>

</style>
