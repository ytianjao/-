<template>
    <div>


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
            <el-table-column v-for="(value, key) in tableData[0]"

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

            <el-form v-for="(value, key) in form">
                <el-form-item :label="key" :label-width="formLabelWidth">
                    <el-input v-model="form[key]" autocomplete="off"></el-input>
                </el-form-item>

            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
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
            console.log(rows)
        },
        addRow(index, rows){
            rows.splice(index,0,[])
        }
    },
    data() {
        return {
            dialogTableVisible: false,
            dialogFormVisible: false,
            drawer:false,
            src:'数据统计表.jpg',
            srclist:['数据统计表.jpg'],
            tableData: [{
                date: '2018-05-03',
                name: '王小虎',
                province: '上海',
                city: '普陀区',
                address: '上海市普陀区金沙江路 1518 弄',
                zip: 200333
            }],
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

        axios.get("http://localhost:8081/biaodan/wenben").then(function (resp){
            // console.log(resp["data"])
            var data = resp.data
            var len = data.length

            var result = []
            for (var i = 0; i< len; i++){
                var data_tmp = data[i]
                data_tmp = data_tmp.split(',')
                if(i == 0){
                    data_tmp.unshift('')
                }
                let json = {}
                for (var j = 0; j< data_tmp.length; j++){
                    _this.$set(json,j, data_tmp[j].replaceAll("'", "").replaceAll("\\", "").replaceAll("n", ""))
                }
                // console.log(json)
                result.push(json)
            }
            console.log(result)
            _this.tableData = result
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
