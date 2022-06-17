<template>
    <div>

        <el-button size="mini" @click="showtext" type="primary">病例选择</el-button>
<!--        <el-button size="mini" @click="showbutton" type="primary" v-show="view2" style="margin-left: 85%">修改</el-button>-->

        <el-dialog title="提交" :visible.sync="dialogFormVisible">
            <el-form :model="form">
                <el-form-item label="实体名称" :label-width="formLabelWidth">
                    <el-input v-model="form.name" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="实体类别" :label-width="formLabelWidth">
                    <el-select v-model="form.region" placeholder="请选择实体类别">
                        <el-option label="类别一" value="shanghai"></el-option>
                        <el-option label="类别二" value="beijing"></el-option>
                    </el-select>
                </el-form-item>


                <el-form-item label="开始位置" :label-width="formLabelWidth">
                    <el-input v-model="form.name" autocomplete="off"></el-input>
                </el-form-item>


                <el-form-item label="结束位置" :label-width="formLabelWidth">
                    <el-input v-model="form.name" autocomplete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
            </div>
        </el-dialog>


        <el-row :gutter="20" v-show="view1" style="font-size: large">
            <el-col :span="13">
                <el-card class="box-card">
                    <div slot="header" class="clearfix">
                        <el-row type="flex"  justify="space-around">
                            <el-col :span="3" v-for= "o in entitilist"><el-button style="width: 100px">{{  o }}</el-button></el-col>
                        </el-row>

                    </div>
                    <div v-for="item in segmentlist"  class="text item"  style="float: left; font-size: large">
                        {{item[0].content}}
                    </div>

                </el-card>
            </el-col>
            <el-col :span="11" :offset="0.5">

                <el-row :gutter="20" style="margin-top: 200px;margin-left: 200px; position: fixed">
                    <el-col :span="2" :offset="9">
                        <el-button type="primary" @click="predict" v-loading.fullscreen.lock="fullscreenLoading">预测</el-button>
                    </el-col>
                </el-row>

            </el-col>
        </el-row>

        <el-row :gutter="20" v-show="view2" style="font-size: large">
            <el-col :span="13">
                <el-card class="box-card" style="font-size: large">
                    <div slot="header" class="clearfix">
                        <el-row type="flex"  justify="center">
                            <el-col  v-for= "o in entitilist"><el-button :class="o" style="width: 100px">{{  o }}</el-button></el-col>
                        </el-row>

                    </div>
                    <div v-for="item in segmentlist"  class="text item" :class=item[0].entity style="float: left; font-size: large">
                        {{item[0].content}}
                    </div>

                </el-card>
            </el-col>
            <el-col :span="11" :offset="0.5">

                <el-tabs type="border-card">

                    <el-tab-pane label="Bert模型">
                        <el-table
                            :data="tableData"
                            style="width: 100%;font-size: large;"
                            height="500">


                            <!--                    <el-table-column prop="entityId" label="序号" width="50">-->

                            <!--                    </el-table-column>-->

                            <el-table-column label="实体名称" width="180">
                                <template slot-scope="scope">
                                    <div v-for=" item in textslice(scope.row.startIndex, scope.row.endIndex)">
                                        {{item}}
                                    </div>
                                </template>
                                <!--                                {{scope.row.entityContent}}-->
                            </el-table-column>
                            <el-table-column width="85" prop="entityContent" label="实体标签" :filters="[{text:'疾病和诊断', value: '疾病和诊断'},{text:'解剖部位', value: '解剖部位'},{text:'实验室检验', value: '实验室检验'},{text:'影像检查', value: '影像检查'},{text:'药物', value: '药物'},{text:'手术', value: '手术'}]" :filter-method="filterHandler">
                                <template slot-scope="scope">
                                    {{scope.row.entityContent}}
                                </template>
                            </el-table-column>
                            <el-table-column width="80" prop="startIndex" label="开始位置">
                                <template slot-scope="scope">
                                    {{scope.row.startIndex}}
                                </template>
                            </el-table-column>
                            <el-table-column width="80" prop="endIndex" label="结束位置">
                                <template slot-scope="scope">
                                    {{scope.row.endIndex}}
                                </template>
                            </el-table-column>

<!--                            <el-table-column  label="">-->
<!--                                <template slot-scope="scope">-->
<!--                                    <el-tooltip  placement="top">-->
<!--                                        <div slot="content">-->
<!--                                            共有{{Math.floor(Math.random() * (10000 - 500)) + 500}}人查看，{{Math.floor(Math.random() * (1000 - 50)) + 50 + scope.row.endIndex}}人提出修改意见-->
<!--                                        </div>-->
<!--                                        <el-button type="danger" size="small" @click="dialogFormVisible=true" v-show="view3">我要修改</el-button>-->
<!--                                    </el-tooltip>-->
<!--                                </template>-->


<!--                            </el-table-column>-->
                        </el-table>
                    </el-tab-pane>
                    <el-tab-pane label="Bert+四角模型">
                        <el-table
                            height="500"
                            :data="tableData"
                            style="width: 100%;font-size: 8px; height: auto">


                            <!--                    <el-table-column prop="entityId" label="序号" width="50">-->

                            <!--                    </el-table-column>-->

                            <el-table-column label="实体名称" width="180">
                                <template slot-scope="scope">
                                    <div v-for=" item in textslice(scope.row.startIndex, scope.row.endIndex)">
                                        {{item}}
                                    </div>
                                </template>
                                <!--                                {{scope.row.entityContent}}-->
                            </el-table-column>
                            <el-table-column width="85" prop="entityContent" label="实体标签" :filters="[{text:'疾病和诊断', value: '疾病和诊断'},{text:'解剖部位', value: '解剖部位'},{text:'实验室检验', value: '实验室检验'},{text:'影像检查', value: '影像检查'},{text:'药物', value: '药物'},{text:'手术', value: '手术'}]" :filter-method="filterHandler">
                                <template slot-scope="scope">
                                    {{scope.row.entityContent}}
                                </template>
                            </el-table-column>
                            <el-table-column width="80" prop="startIndex" label="开始位置">
                                <template slot-scope="scope">
                                    {{scope.row.startIndex}}
                                </template>
                            </el-table-column>
                            <el-table-column width="80" prop="endIndex" label="结束位置">
                                <template slot-scope="scope">
                                    {{scope.row.endIndex}}
                                </template>
                            </el-table-column>

<!--                            <el-table-column  label="">-->
<!--                                <template slot-scope="scope">-->
<!--                                    <el-tooltip  placement="top">-->
<!--                                        <div slot="content">-->
<!--                                            共有{{Math.floor(Math.random() * (10000 - 500)) + 500}}人查看，{{Math.floor(Math.random() * (1000 - 50)) + 50 + scope.row.endIndex}}人提出修改意见-->
<!--                                        </div>-->
<!--                                        <el-button type="danger" size="small" @click="dialogFormVisible=true" v-show="view3">我要修改</el-button>-->
<!--                                    </el-tooltip>-->
<!--                                </template>-->


<!--                            </el-table-column>-->
                        </el-table>
                    </el-tab-pane>
                </el-tabs>

            </el-col>
        </el-row>



    </div>
</template>

<script>
export default {
    name: "NERTest",
    data(){
        return{
            fullscreenLoading: false,
            text:'',
            view1: true,
            view2: false,
            view3: false,
            drawer: false,
            allTable: [],
            textlen: 5,
            textlist: [],
            indexlist: [],
            segmentlist: [],
            entitilist: ['疾病和诊断', '解剖部位','实验室检验','影像检查','手术','药物'],
            tableData: [{
                entityId: null,
                entityContent: '',
                startIndex: null,
                endIndex: null,
                textId: null,

            }],

            dialogFormVisible: false,
            form: {
                name: '',
                region: '',
                date1: '',
                date2: '',
                delivery: false,
                type: [],
                resource: '',
                desc: ''
            },
            formLabelWidth: '120px'
        }
    },
    methods:{
        showbutton(){
          this.view3 = true
        },
        showtext(){
            this.$router.push({
                path: '/texttable3'
            })
        },

        predict(){

            this.fullscreenLoading = true;
            setTimeout(() => {
                this.fullscreenLoading = false;
                this.view1 = false
                this.view2 = true
            }, 1000);

        },

        filterHandler(value, row, column) {
            const property = column['property'];
            return row[property] === value;
        },
        textslice(start, end) {
            return [this.text.slice(start, end)]
        }
    },
    created() {
        const _this = this
        axios.get('http://localhost:8081/cckstext/select/'+_this.$route.query.textId).then(function (resp) {
            _this.textlist = resp.data.textContent.split('')
            _this.text = resp.data.textContent
        })
        axios.get('http://localhost:8081/ccksentity/fingbytextid/?textId='+_this.$route.query.textId).then(function (resp) {
            // console.log(resp.data.length)
            var data = resp.data
            var len = data.length

            _this.segmentlist.push([{'content':_this.textlist.slice(0, data[0]['startIndex']).toString(), 'entity':'black'}])
            for (var i = 0; i< len-1; i++){
                var start = data[i]['startIndex'];
                var end = data[i]['endIndex']

                _this.segmentlist.push(
                    [{'content':_this.textlist.slice(data[i]['startIndex'],data[i]['endIndex']).toString(), 'entity': data[i]['entityContent']}]
                )
                _this.segmentlist.push([{'content':_this.textlist.slice(data[i]['endIndex'],data[i+1]['startIndex']).toString(), 'entity':'black'}])
            }
            _this.segmentlist.push([{'content':_this.textlist.slice(data[len-1]['startIndex'],data[len-1]['endIndex']).toString(), 'entity':data[len-1]['entityContent']}])
            _this.segmentlist.push([{'content':_this.textlist.slice(data[len-1]['endIndex']).toString(), 'entity':'black'}])
            // console.log(_this.segmentlist)
            _this.textlen = _this.segmentlist.length
            // console.log(_this.indexlist)
            _this.tableData = resp.data
        })
        console.log(this.tableData)
        // this.allTable = this.tableData
        this.allTable = JSON.parse(JSON.stringify(this.tableData))
    }

}
</script>

<style scoped>
.el-row {
    margin-bottom: 20px;
&:last-child {
     margin-bottom: 0;
 }
}
.el-col {
    border-radius: 4px;
}
.text {
    font-size: 14px;
}
.疾病和诊断 {
    background: #B3C0D1;
}

.解剖部位 {
    background: #42b983;
}

.实验室检验 {
    background: #FFB6C1;
}

.影像检查 {
    background: #6495ED;
}

.手术 {
    background: #98FB98;
}

.药物 {
    background: #F0E68C;
}
.item {
    margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
    display: table;
    content: "";
}
.clearfix:after {
    clear: both
}

.box-card {
    /*width: 480px;*/
}
</style>


