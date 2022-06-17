<template>
    <div>
<!--        <p>已有预测成功的数据</p>-->
        <el-table :data="textTable">
            <el-table-column prop="textId" label="病例序号" width="140">
                <template slot-scope="scope">
                    病例编号{{scope.row.textId}}
                </template>
            </el-table-column>
            <el-table-column prop="textContent" label="内容" show-overflow-tooltip="true">
<!--                文本内容-->
            </el-table-column>
            <el-table-column fixed="right" width="120px">
                <template slot-scope="scope">
                    <el-button @click="select(scope.row)">
                        查看
                    </el-button>
                </template>

            </el-table-column>
        </el-table>
        <br>

        <el-row type="flex" class="row-bg" justify="center">
            <el-col :span="6">
                <el-pagination
                    background
                    layout="prev, pager, next"
                    @current-change="page"
                    :page-size=pageSize
                    :total=total>
                </el-pagination>
            </el-col>
            </el-row>

<!--        <el-row type="flex" class="row-bg" justify="end">-->
<!--            <el-button type="primary" id="insert" @click="add()">添加</el-button>-->
<!--        </el-row>-->



    </div>


</template>

<script>
export default {
    name: "TextTable3",
    data(){
        return{
            textTable: [{
                textId: null,
                textName: '',
                textContent: '',
            }],
            total: 20,
            pageNum: 1,
            pageSize: 5
        }
    },

    created() {
        const _this = this
        axios.get("http://localhost:8081/cckstext/listallbypage/?pagenum=" + this.pageNum + '&pagesize=' + this.pageSize).then(function (resp) {
            console.log(resp)
            _this.textTable = resp.data.list
            _this.total = resp.data.total
        })
    },

    methods: {
        select(row){
          console.log(row.textId)
            this.$router.push({
                path: '/ner',
                query:{
                    textId: row.textId
                }
            })
        },
        add(){
            this.$router.push({
                path: '/addtext'
            })
        },

        page(currentPage){
            // alert(currentPage)
            const _this = this
            axios.get("http://localhost:8081/cckstext/listallbypage/?pagenum=" + currentPage + '&pagesize=' + this.pageSize).then(function (resp) {
                console.log(resp)
                _this.textTable = resp.data.list
                _this.total = resp.data.total
            })
        }
    }
}


</script>

<style>
    .el-row {
        margin-bottom: 20px;
    &:last-child {
         margin-bottom: 0;
     }
    }
    .el-col {
        border-radius: 4px;
    }

</style>
