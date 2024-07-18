<template>
  <div>
    <div>
      <el-table :data="emps" border stripe size="mini">
        <el-table-column type="selection" align="left" width="55"></el-table-column>
        <el-table-column prop="name" label="姓名" fixed width="120" align="left"></el-table-column>
        <el-table-column prop="workID" label="工号" width="120" align="left"></el-table-column>
        <el-table-column prop="email" label="电子邮件" width="200" align="left"></el-table-column>
        <el-table-column prop="phone" label="电话号码" width="120" align="left"></el-table-column>
        <el-table-column prop="department.name" label="所属部门" width="120" align="left"></el-table-column>
        <el-table-column label="所属部门" align="center">
          <template #default="scope">
            <el-tooltip placement="right" v-if="scope.row.salary">
              <div slot="content">
                <table>
                  <tr>
                    <td>基本工资</td>
                    <td>{{scope.row.salary.basicSalary}}</td>
                  </tr>
                  <tr>
                    <td>交通补助</td>
                    <td>{{scope.row.salary.trafficSalary}}</td>
                  </tr>
                  <tr>
                    <td>午餐补助</td>
                    <td>{{scope.row.salary.lunchSalary}}</td>
                  </tr>
                  <tr>
                    <td>奖金</td>
                    <td>{{scope.row.salary.bonus}}</td>
                  </tr>
                  <tr>
                    <td>养老金比率</td>
                    <td>{{scope.row.salary.pensionPer}}</td>
                  </tr>
                  <tr>
                    <td>养老金基数</td>
                    <td>{{scope.row.salary.pensionBase}}</td>
                  </tr>
                  <tr>
                    <td>医疗保险比率</td>
                    <td>{{scope.row.salary.medicalPer}}</td>
                  </tr>
                  <tr>
                    <td>医疗保险基数</td>
                    <td>{{scope.row.salary.medicalBase}}</td>
                  </tr>
                  <tr>
                    <td>公积金比率</td>
                    <td>{{scope.row.salary.accumulationFundPer}}</td>
                  </tr>
                  <tr>
                    <td>公积金基数</td>
                    <td>{{scope.row.salary.accumulationFundBase}}</td>
                  </tr>
                  <tr>
                    <td>启用时间</td>
                    <td>{{scope.row.salary.createDate}}</td>
                  </tr>
                </table>
              </div>
              <el-tag>{{scope.row.salary.name}}</el-tag>
            </el-tooltip>
            <el-tag v-else>暂未设置</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center">
          <template #default="scope">
            <el-popover
                placement="left"
                title="修改工资账套"
                @show="showPop(scope.row.salary)"
                @hide="hidePop(scope.row)"
                width="200"
                trigger="click">
              <div>
                <el-select v-model="currentSalary" placeholder="请选择" size="mini">
                  <el-option
                      v-for="item in salaries"
                      :key="item.id"
                      :label="item.name"
                      :value="item.id">
                  </el-option>
                </el-select>
              </div>
              <el-button slot="reference" type="danger">修改工资账套</el-button>
            </el-popover>
          </template>
        </el-table-column>
      </el-table>
      <div style="display: flex;justify-content: flex-end">
        <el-pagination
            background
            @size-change="sizeChange"
            @current-change="currentChange"
            layout="sizes, prev, pager, next, jumper, ->, total, slot"
            :total="total">
        </el-pagination>
      </div>
    </div>
  </div>
</template>

<script>
import { ref, onMounted } from 'vue';
import {getRequest} from "@/api/api.js";

export default {
  name: "SalSobCfg",
  setup() {
    const emps = ref([]);
    const total = ref(0);
    const currentPage = ref(1);
    const currentSize = ref(10);
    const currentSalary = ref(null);
    const salaries = ref([]);

    const initSalaries = async () => {
      const resp = await getRequest("/salary/sobcfg/salaries");
      if (resp) {
        salaries.value = resp;
      }
    };

    const initEmps = async () => {
      const resp = await getRequest(`/salary/sobcfg/?page=${currentPage.value}&size=${currentSize.value}`);
      if (resp) {
        emps.value = resp.data;
        total.value = resp.total;
      }
    };

    const sizeChange = (size) => {
      currentSize.value = size;
      initEmps();
    };

    const currentChange = (page) => {
      currentPage.value = page;
      initEmps();
    };

    const hidePop = async (data) => {
      if (currentSalary.value) {
        const resp = await putRequest(`/salary/sobcfg/?eid=${data.id}&sid=${currentSalary.value}`);
        if (resp) {
          initEmps();
        }
      }
    };

    const showPop = (data) => {
      if (data) {
        currentSalary.value = data.id;
      } else {
        currentSalary.value = null;
      }
    };

    onMounted(() => {
      initEmps();
      initSalaries();
    });

    return {
      emps,
      total,
      currentPage,
      currentSize,
      currentSalary,
      salaries,
      sizeChange,
      currentChange,
      hidePop,
      showPop
    };
  }
};
</script>

<style scoped>
/* 样式 */
</style>
