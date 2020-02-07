<template>
    <div>
      <h1>user Manage</h1>
      <el-card>
        <el-table
          :data="tableData"
          stripe
          style="width: 100%">
          <el-table-column
            prop="date"
            label="日期"
            width="180">
          </el-table-column>
          <el-table-column
            prop="name"
            label="姓名"
            width="180">
          </el-table-column>
          <el-table-column
            prop="address"
            label="地址">
          </el-table-column>
        </el-table>
      </el-card>
    </div>
</template>

<script>
    export default {
        name: "index",
        data() {
            return{
                tableData: null
            }
        }
    }
</script>

<style scoped>
  .el-header{
    color: #333;
    text-align: center;
    line-height: 60px;
  }
  .el-main {
    color: #333;
    text-align: center;
    /*line-height: 160px;*/
  }
</style>
