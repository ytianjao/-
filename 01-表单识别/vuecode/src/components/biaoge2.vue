<template>
    <div>
<!--        <el-button @click="drawer = true" type="primary" style="margin-left: 16px;">-->
<!--            点我打开-->
<!--        </el-button>-->

        <el-drawer
            title="我是标题"
            :visible.sync="drawer"
            direction="ltr"
            :with-header="false">
            <span>我来啦!</span>
        </el-drawer>

        <el-image
            style="width: 800px"
            :src="src"
            :fit="contain"
            :preview-src-list="src"></el-image>
        <el-table
            :data="tableData"
            style="width: 100%"
            max-height="300"
            width="200"
        >
<!--            :label="key"-->
            <el-table-column v-for="(value, key) in tableData[0]" v-if="key != 'id'"

                :prop="key"

                width="100">
            </el-table-column>

            <el-table-column
                fixed="right"
                label="操作"
                width="120">
                <template slot-scope="scope">
                    <el-button
                        size="mini"
                        @click="EditRow(scope.$index, scope.row)">Edit
                    </el-button>
                    <el-button
                        @click.native.prevent="deleteRow(scope.$index, tableData)"
                        type="text"
                        size="small">
                        移除
                    </el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-dialog title="" :visible.sync="dialogFormVisible">

            <el-form v-for="(value, key) in form" v-if="key != 'id'">
                <el-form-item :label="key" :label-width="formLabelWidth">
                    <el-input v-model="form[key]" autocomplete="off"></el-input>
                </el-form-item>

            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="submitData(form)">确 定</el-button>
            </div>
        </el-dialog>
    </div>


</template>

<script>
export default {
    name: "biaoge",
    methods: {
        deleteRow(index, rows) {
            rows.splice(index, 1);
        },
        EditRow(index, rows) {
            this.dialogFormVisible = true
            this.form = rows
            console.log(index)
            this.cur_index = index
        },
        addRow(index, rows){
            rows.splice(index,0,[])
        },
        convert(key){
            return this.table_dict[key]
        },
        submitData(form){
            this.dialogFormVisible = false
            console.log(this.tableData[this.cur_index])
            console.log(this.tableData[this.cur_index]['id'])
            this.update(this.tableData[this.cur_index]['id'], this.tableData[this.cur_index])
        },
        update(cur_index, form){
            axios.post("http://localhost:8081/biaodan/update/" + this.tableData[this.cur_index]['id'], form).then(function (resp) {
                console.log(resp)
            })
        }
    },
    data() {
        return {
            cur_index:0,
            dialogTableVisible: false,
            dialogFormVisible: false,
            drawer:false,
            src:'数据统计表.jpg',
            srclist:['数据统计表.jpg'],
            tableData: [{
                xuhao: '2018-05-03',
                zhongliang: '王小虎',
                yuanzhou: '上海',
                xizu: '普陀区',
                yingdu: '上海市普陀区金沙江路 1518 弄',
                changdu: 200333,
                shuifen: 200333,
                siliang: 200333,
                juanyanji: 200333,
                baozhuangji: 200333,
            },
                ],
            table_dict: [{
                xuhao:"序号",
                zhongliang:"重量",
                yuanzhou:"",
                xizu:"",
                tongfeng:"",
                yingdu:"",
                changdu:"",
                shuifen:"",
                siliang:"",
                juanyanji:"",
                baozhuangji:""
            }
            ],
            form: {
                name: '',
                province: '',
                city: '',

            },
            formLabelWidth: '120px'
        }
    },
    created() {
        const _this =this

        axios.get("http://localhost:8081/biaodan/data").then(function (resp){
            // console.log(resp["data"])
            var data = resp.data


            _this.tableData = data
        })
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
.bg-purple-dark {
    background: #99a9bf;
}
.bg-purple {
    background: #d3dce6;
}
.bg-purple-light {
    background: #e5e9f2;
}
.grid-content {
    border-radius: 4px;
    min-height: 200px;
}
.row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
}
</style>
