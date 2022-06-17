<template>
    <div class="">
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <el-row type="flex" justify="center">
                    <el-col v-for="o in entitilist">
                        <el-button :class="o">{{ o }}</el-button>
                    </el-col>
                </el-row>

            </div>
            <div v-for="item in segmentlist" class="text item" :class=item[0].entity style="float: left; font-size: large">
                {{ item[0].content }}
            </div>

        </el-card>
    </div>
</template>

<script>
export default {
    name: "knowQuestion",
    data() {
        return {
            drawer: false,
            allTable: [],
            textlen: 5,
            textlist: [],
            indexlist: [],
            segmentlist: [],
            entitilist: ['疾病和诊断', '解剖部位', '实验室检验', '影像检查', '手术', '药物'],
            tableData: [{
                entityId: null,
                entityContent: '',
                startIndex: null,
                endIndex: null,
                textId: null
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
    methods: {

        filterHandler(value, row, column) {
            const property = column['property'];
            return row[property] === value;
        },
    },
    created() {
        const _this = this
        axios.get('http://localhost:8081/cckstext/select/'+_this.$route.query.textId).then(function (resp) {
            _this.textlist = resp.data.textContent.split('')
        })
        axios.get('http://localhost:8081/ccksentity/fingbytextid/?textId='+_this.$route.query.textId).then(function (resp) {
            // console.log(resp.data.length)
            var data = resp.data
            var len = data.length

            _this.segmentlist.push([{
                'content': _this.textlist.slice(0, data[0]['startIndex']).toString(),
                'entity': 'black'
            }])
            for (var i = 0; i < len - 1; i++) {
                var start = data[i]['startIndex'];
                var end = data[i]['endIndex']

                _this.segmentlist.push(
                    [{
                        'content': _this.textlist.slice(data[i]['startIndex'], data[i]['endIndex']).toString(),
                        'entity': data[i]['entityContent']
                    }]
                )
                _this.segmentlist.push([{
                    'content': _this.textlist.slice(data[i]['endIndex'], data[i + 1]['startIndex']).toString(),
                    'entity': 'black'
                }])
            }
            _this.segmentlist.push([{
                'content': _this.textlist.slice(data[len - 1]['startIndex'], data[len - 1]['endIndex']).toString(),
                'entity': data[len - 1]['entityContent']
            }])
            _this.segmentlist.push([{
                'content': _this.textlist.slice(data[len - 1]['endIndex']).toString(),
                'entity': 'black'
            }])
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
/*.back{*/
/*    background-image: url("C:\\Users\\Administrator\\Desktop\\1.jpeg");*/
/*    background-repeat: no-repeat;*/
/*    background-size: cover;*/

/*    filter:alpha(Opacity=85);*/
/*    -moz-opacity:0.85;*/
/*    opacity: 0.85;*/
/*}*/

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
