<template>
  <div>
    <el-menu :default-openeds="['1']" background-color="#545c64" text-color="#fff"
             active-text-color="#ffd04b">
      <el-menu-item index="0" @click="navRouter({path: '/home'})">
        <template slot="title">
          <i class="el-icon-s-home"></i>
          <span>主页</span>
        </template>
      </el-menu-item>
      <!-- 目录 -->
      <el-submenu :index="item.id + ''" v-for="item in menus" :key="item.name">
        <template slot="title">
          <i :class="item.icon"></i>
          <span slot="title">{{item.name}}</span>
        </template>
        <el-menu-item-group>
          <!-- 子菜单 -->
          <el-menu-item v-for="childItem in item.children" :key="childItem.name" :index="childItem.id + ''" @click="navRouter(childItem.path)">
              <template slot="title">
                <i :class="childItem.icon"></i>
                <span>{{childItem.name}}</span>
              </template>
          </el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </div>
</template>
<script>
    import {  mapGetters } from 'vuex'
    export default {
        data() {
            return {
            }
        },
        props: {
            isCollapse: {
                type: Boolean
            }
        },
        methods: {
            navRouter(url) {
                this.$router.push(url);
            },
        },
        computed:{
            ...mapGetters([
                'permissions'
            ]),
            menus(){
                return this.permissions;
            }
        }
    };
</script>
