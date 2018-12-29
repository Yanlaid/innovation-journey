<template>
  <div>
    <!--查询表单-->
    <el-form :inline="true" class="demo-form-inline">
      <el-form-item label="活动名称">
        <el-input v-model="searchMap.gatheringName" placeholder="活动名称"></el-input>
      </el-form-item>
      <el-form-item label="活动区域">
        <el-select v-model="searchMap.sponsor" placeholder="活动区域">
          <el-option label="区域一" value="shanghai"></el-option>
          <el-option label="区域二" value="beijing"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="fetchData">查询</el-button>
        <el-button type="primary" @click="handleAdd">新增</el-button>
      </el-form-item>
    </el-form>

    <!--table控件-->
    <el-table :data="list" border style="width: 100%">
      <el-table-column prop="id" label="活动ID" width="180"></el-table-column>
      <el-table-column prop="name" label="活动名称" width="180"></el-table-column>
      <el-table-column prop="sponsor" label="主办方" width="180"></el-table-column>
      <el-table-column prop="address" label="活动地址" width="180"></el-table-column>
      <el-table-column prop="starttime" label="开始日期" width="180"></el-table-column>
      <el-table-column prop="endtime" label="结束日期" width="180"></el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="100">
        <template slot-scope="scope">
          <!--scope.row.id 代表当前行的id-->
          <el-button @click="handleEdit(scope.row.id)" type="text" size="small">编辑</el-button>
          <el-button @click="handleDelete(scope.row.id)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--分页组件-->
    <el-pagination
      @size-change="fetchData"
      @current-change="fetchData"
      :current-page="currentPage"
      :page-sizes="[5, 10, 20]"
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total">
    </el-pagination>
    <!--新增组件-->
    <el-dialog title="编辑" :visible.sync="dialogFormVisible">
      <el-form label-width="80px">
        <el-form-item label="活动名称">
          <el-input v-model="pojo.name" placeholder="活动名称"></el-input>
        </el-form-item>
        <el-form-item label="城市">
          <el-select v-model="pojo.city" placeholder="请选择">
            <el-option
              v-for="item in cityList"
              :key="item.id"
              :label="item.name"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="开始日期">
          <el-date-picker type="date" v-model="pojo.starttime" placeholder="开始日期"></el-date-picker>
        </el-form-item>
        <el-form-item label="截至日期">
          <el-date-picker type="date" v-model="pojo.endtime" placeholder="截至日期"></el-date-picker>
        </el-form-item>
        <el-form-item label="报名截止">
          <el-date-picker type="date" v-model="pojo.enrolltime" placeholder="报名截止"></el-date-picker>
        </el-form-item>
        <el-form-item label="活动详情">
          <el-input v-model="pojo.detail" placeholder="活动详情" type="textarea" :rows="2"></el-input>
        </el-form-item>
        <el-form-item label="是否可见">
          <el-switch active-value="1" inactive-value="0" v-model="pojo.status"></el-switch>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="savePojo">保存</el-button>
          <el-button @click="dialogFormVisible = false">关闭</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>
<script>
  import gatheringApi from '@/api/gathering'
  import cityApi from '@/api/city'

  export default {
    data() {
      return {
        list: [],
        currentPage: 1,
        pageSize: 10,
        total: 0,
        searchMap: {},
        dialogFormVisible: false,  //控制新增对话框显示与否
        pojo: {}, //新增活动表单对象
        cityList: [],
        id: 0
      }
    },
    created() {
      this.fetchData()
      cityApi.getCityList().then(resp => {
        this.cityList = resp.data
      })
    },
    methods: {
      fetchData() {
        // alert(this.currentPage);
        gatheringApi
          //TODO 此处取值
          .getPageList(this.currentPage, this.pageSize, this.searchMap)
          .then(resp => {
            if (resp.flag) {
              this.total = resp.data.total
              this.list = resp.data.rows
            }
          })
      },
      savePojo() {
        if ((this.id === 0)) {
          /*add pojo*/
          this.add()
        } else {
          /*update pojo*/
          this.update(this.id, this.pojo)
        }

      },
      /*编辑*/
      handleEdit(id) {
        this.id = id
        gatheringApi.findById(id).then(resp => {
          this.pojo = resp.data
          this.dialogFormVisible = true
        })
      },
      add() {
        gatheringApi.save(this.pojo).then(resp => {
          this.$message({
            showClose: true,
            message: resp.message,
            type: resp.flag ? 'success' : 'warning'
          })
          if (resp.flag) {
            this.pojo = {}
            this.dialogFormVisible = false
            this.fetchData()
          }
        })
      },
      update(id, pojo) {
        gatheringApi.updatePojo(id, this.pojo).then(resp => {
          this.$message({
            showClose: true,
            message: resp.message,
            type: resp.flag ? 'success' : 'warning'
          })
          if (resp.flag) {
            this.id = 0
            this.pojo = {}
            this.dialogFormVisible = false
            this.fetchData()
          }
        })
      },
      handleAdd() {
        this.id = 0
        this.pojo = {}
        this.dialogFormVisible = true
      },
      handleDelete(id) {

        this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          gatheringApi.deletePojoById(id).then(resp => {
            this.$message({
              type: resp.flag ? 'success' : 'warning',
              message: resp.message
            })
            if (resp.flag) {
              this.fetchData()
            }
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          })
        })
      }
    }
  }
</script>
