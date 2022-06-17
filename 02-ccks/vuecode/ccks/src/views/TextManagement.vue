<template>
    <div>

        <el-button @click="drawer = true" type="primary" style="margin-left: 19%;">
            病例选择
        </el-button>

        <el-drawer
            title="我是标题"
            :visible.sync="drawer"
            :with-header="false">
            <el-table :data="textTable">
                <el-table-column prop="textId" label="病例编号">
                    <template slot-scope="scope">
                        <el-link :underline="false" :href="'/textmanage?textId='+scope.row.textId">病例编号{{ scope.row.textId }}</el-link>
                    </template>
                </el-table-column>
            </el-table>
        </el-drawer>
        <el-row :gutter="20" style="font-size: large">
            <el-col :span="12">
                <div class="grid-content bg-purple" id="text" @click="descInput">
                    <el-input id="textarea" ref="test" v-model="textContent" type="textarea"
                              maxlength="1000"
                              :autosize="{ minRows: 20}" :readonly="true" style="font-size: 20px"></el-input>
<!--                    <span>{{ remnant }}</span>-->
                </div>
            </el-col>

            <el-col :span="12" >
                <div class="right_card" >
                    <el-form :model="form">
                        <el-form-item label="实体名称" :label-width="formLabelWidth">
                            <el-input v-model="form.name" autocomplete="off"></el-input>
                        </el-form-item>
                        <el-form-item label="实体类别" :label-width="formLabelWidth">
                            <el-select v-model="form.region" placeholder="请选择实体类别">
                                <el-option label="疾病和诊断" value="shanghai"></el-option>
                                <el-option label="解剖部位" value="beijing"></el-option>
                                <el-option label="手术" value="beijing"></el-option>
                                <el-option label="药物" value="beijing"></el-option>
                                <el-option label="实验室检验" value="beijing"></el-option>
                                <el-option label="影像检查" value="beijing"></el-option>
                            </el-select>
                        </el-form-item>


                        <el-form-item label="开始位置" :label-width="formLabelWidth" >
                            <el-input v-model="form.start" autocomplete="off"></el-input>
                        </el-form-item>


                        <el-form-item label="结束位置" :label-width="formLabelWidth">
                            <el-input v-model="form.end" autocomplete="off"></el-input>
                        </el-form-item>
                    </el-form>

                    <el-row :gutter="20">
                        <el-col :span="12" :offset="10">
                            <el-button type="primary" round @click="subEntity">提 交</el-button>
                        </el-col>
                    </el-row>
                    <el-row type="flex" class="row-bg" style="margin-left: 250px">
                        <el-button type="primary" id="insert" @click="add()">管理员审核</el-button>
                    </el-row>
                </div>

            </el-col>

            <!--            <el-col :span="12" :offset="2">-->
            <!--                <div class="grid-content bg-purple">-->

            <!--                    <el-table :data="tableData" height="450" ref="entityTable">-->

            <!--                        <el-table-column prop="entityId" label="序号" >-->
            <!--                            <template slot-scope="scope">-->
            <!--                                <span v-model="scope.row.entityId">{{ scope.row.entityId }}</span>-->
            <!--                            </template>-->
            <!--                        </el-table-column>-->
            <!--                        <el-table-column prop="entityContent" label="实体标签" width="150px">-->
            <!--                            <template slot-scope="scope">-->
            <!--                                <el-input v-model="scope.row.entityContent" style="width: 110px"></el-input>-->
            <!--                            </template>-->
            <!--                        </el-table-column>-->
            <!--                        <el-table-column prop="startIndex" label="开始位置">-->
            <!--                            <template slot-scope="scope">-->
            <!--                                <el-input v-model="scope.row.startIndex"></el-input>-->
            <!--                            </template>-->
            <!--                        </el-table-column>-->
            <!--                        <el-table-column prop="endIndex" label="结束位置">-->
            <!--                            <template slot-scope="scope">-->
            <!--                                <el-input v-model="scope.row.endIndex"></el-input>-->
            <!--                            </template>-->
            <!--                        </el-table-column>-->
            <!--                        <el-table-column>-->
            <!--                            <template slot-scope="scope">-->
            <!--                                <el-button @click="update(scope.row)" v-if="scope.row.entityId">修改</el-button>-->
            <!--                                <el-button @click="addentity(scope.row)" v-if="!scope.row.entityId">添加</el-button>-->
            <!--                            </template>-->

            <!--                        </el-table-column>-->

            <!--                    </el-table>-->
            <!--                    <el-row style="background: #FFF">-->
            <!--                        <el-col :span="2" :offset="11" style="background: #FFFFFF">-->

            <!--                            <el-button-->
            <!--                                @click="addRow()"-->
            <!--                                type="text"-->
            <!--                                size="small">-->
            <!--                                添加-->
            <!--                            </el-button>-->

            <!--                        </el-col>-->
            <!--                    </el-row>-->

            <!--                </div>-->

            <!--            </el-col>-->


        </el-row>
        <!--        <el-row :gutter="20">-->
        <!--            <el-col>-->
        <!--                <el-button :span="1" :offset="12">111</el-button>-->
        <!--            </el-col>-->
        <!--        </el-row>-->
    </div>
</template>

<script>
export default {
    data() {
        return {
            drawer: false,
            textTable: [{
                textId: null,
                textName: '',
                // textContent: ''
            }],
            form: {
                name: '',
                region: '',
                date1: '',
                date2: '',
                delivery: false,
                type: [],
                resource: '',
                desc: '',
                start: '',
                end: ''
            },
            formLabelWidth: '120px',


            tableData: [{
                entityId: null,
                entityContent: '',
                startIndex: null,
                endIndex: null,
                textId: null

            }],
            textId: null,
            textContent: '',
            remnant: 0
        }
    },
    methods: {

        add(){
            this.$router.push({
                path: '/adminselect'
            })
        },

        selecttextmanage(row){
            this.$router.push({
                path: '/textmanage',
                query:{
                    textId: row.textId
                }
            })
        },
        subEntity(){
            this.$alert('实体：<strong>'+this.form.name+'</strong> 提交成功', '提交结果', {
                confirmButtonText: '确定',
                dangerouslyUseHTMLString: true
                // callback: action => {
                //     this.$message({
                //         type: 'info',
                //         // message: `action: ${ action }`
                //     });
                // }
            });

            this.form.name = ''
            this.form.start = ''
            this.form.end = ''
        },
        descInput() {
            var index = this.$refs['test'].$refs['textarea'].selectionStart
            var end = this.$refs['test'].$refs['textarea'].selectionEnd
            // var desc = this.$refs['test'].getSelection.toString()
            var desc = this.textContent.slice(index, end)
            this.form.start = index
            this.form.end = end
            this.form.name = desc
            console.log(index)
            console.log(end)
            console.log(desc)
            this.remnant = index;

        },
        addentity(row) {
            // console.log(row)
            axios.post("http://localhost:8081/ccksentity/add", row).then(function (resp) {
                console.log(resp)
                if (resp.data == 'success') {
                    window.location.reload()
                }
            })
            // window.location.reload()
        },

        addRow() {
            var newEntity = {
                entityId: null,
                entityContent: '',
                startIndex: null,
                endIndex: null,
                textId: this.textId
            }
            this.tableData.push(newEntity)
        },
        update(row) {
            console.log(row)
            axios.post("http://localhost:8081/ccksentity/update/" + row.textId, row).then(function (resp) {
                console.log(resp)
            })
            alert("修改成功")
        }
    },
    created() {
        const _this = this
        axios.get('http://localhost:8081/ccksentity/fingbytextid/?textId=' + _this.$route.query.textId).then(function (resp) {
            console.log(resp)
            _this.tableData = resp.data
            // _this.textId = resp.data.textId
        })
        axios.get('http://localhost:8081/cckstext/select/' + _this.$route.query.textId).then(function (resp) {
            console.log(resp)
            // _this.tableData = resp.data
            _this.textContent = resp.data.textContent
            _this.textId = resp.data.textId
        })

        axios.get("http://localhost:8081/cckstext/listallbypage/?pagenum=1"+ '&pagesize=100').then(function (resp) {
            console.log(resp)
            _this.textTable = resp.data.list
            _this.total = resp.data.total
        })
    }
};
</script>


<style>

.right_card{
    position: fixed;
    width: 100%;
}
.el-row {
    margin-bottom: 20px;

&
:last-child {
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
    border-radius: 1px;
    min-height: 36px;
}

.row-bg {
    padding: 1px 0;
    background-color: #f9fafc;
}
</style>
