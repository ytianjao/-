<template>
    <div>
        <el-form :inline="true" :model="formInline" class="demo-form-inline">
            <el-form-item label="查询疾病">
                <el-input v-model="formInline.diseasename" placeholder="查询实体"></el-input>
            </el-form-item>
            <el-form-item label="相关类别">
                <el-select v-model="formInline.entityclassuri" placeholder="相关类别">
                    <el-option label="药物" value="drugnodesbydisease"></el-option>
                    <el-option label="手术" value="operationnodesbydisease"></el-option>
                    <el-option label="解剖部位" value="bodynodesbydisease"></el-option>
                    <el-option label="影像检查" value="checknodesbydisease"></el-option>
                    <el-option label="实验室检验" value="testnodesbydisease"></el-option>
                    <el-option label="疾病与诊断" value="diseasenodesbydisease"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">查询</el-button>
            </el-form-item>
        </el-form>

<!--        <el-button type="text" @click="dialogTableVisible = true">打开嵌套表格的 Dialog</el-button>-->

        <el-dialog :visible.sync="dialogTableVisible">
            <div slot="title">
                相关病例：{{selectedName}}
            </div>
            <el-table :data="gridData">
                <el-table-column property="date" label="序号" width="100"></el-table-column>
                <el-table-column property="address" label="病例内容" width="400" show-overflow-tooltip="true"></el-table-column>
                <el-table-column>

                    <template slot-scope="scope">
                        <el-button @click="select(scope.row)">
                            查看
                        </el-button>
                    </template>
 </el-table-column>

            </el-table>
        </el-dialog>
        <div id="main" style="height: 600px" ref="kgchart"></div>

    </div>
</template>

<script>
import MessageBox from "element-ui/packages/message-box/src/main";

export default {
    name: "KGTest",
    data() {
        return {
            selectedName: null,
            gridData: [{
                date: '16',
                name: 'CCKS2019',
                address: '患者近1月前（2016-02-23）前因“胃癌”于我院行胃癌姑息性切除术（远端胃大部切除+毕I式吻合），，术中探查见：肿瘤位于胃窦小弯侧，大小约5*4*3CM,侵透浆膜并侵及胰腺，胃周可见多组肿大淋巴结，其中7、8、9组淋巴结融合成团，并与胰腺浸润。，术后常规病理示：（胃）低分化腺癌，局灶伴印戒细胞癌分化，弥漫浸润型，肿瘤切面积5.5*0.8CM，侵及胃壁深肌层。双端切缘、吻合器切缘及网膜组织未查见癌。大弯侧淋巴结11枚，其中3枚（3/11）查见转移；第7、8组淋巴结9枚，其中1枚（1/9）查见转移；小弯侧淋巴结8枚，均未查见转移（0/8）。，免疫组化：CK（+）、HER-2（2+）、SYN（-）、E-CAD（+）。术后给予消炎、营养支持治疗，病情好转后出院。现患者无恶心、呕吐，无腹痛、腹胀，半流质饮食，二便正常。现为求进一步治疗，门诊以“胃癌术后”收入院。自下次出院来，神志清，精神可，饮食可，体重较前无明显改变。'
            }, {
                date: '17',
                name: 'CCKS2019',
                address: '罹患残胃癌于2013-9-6在我院予行全麻上全胃切除术（空肠J字代胃）；，术中探查见：腹腔内严重粘连，腹腔内无腹水，肝脏无法探查，盆底腹膜无异常；肿瘤位于残胃后壁，溃疡性肿块，约10 X 8CM。肿瘤侵出浆膜层。患者术后积极予相关对症支持治疗并恢复顺利良好。相关手术病理(2013 11248），示：残胃低分化腺癌，体积7.5*7*3.2CM，蕈伞型，侵达浆膜。双端切线及另送“胃远端切线”未查见癌。贲门周围（10个）淋巴结未查见癌。，免疫组化染色示癌组织：ERCC1（+）、β-TUBULIN-III（+）、TS（-）、RRM1（-）、TOPOII（阳性数60%）、CERBB-2（-）。合患者病情及肿瘤病理与分期继续予行术后化疗相关辅助治疗指征存在；依情先后予2013-9、2013-10予行术后辅助化疗2周期，，具体用药为：奥沙利铂200MG D1+亚叶酸钙0.3G D2-6 +替加氟1000MG D2-6 静滴，同时辅以镇吐、升血、免疫调节等对症支持治疗（化疗期间患者总体耐受性良好；复查血像示外周血白细胞减少，予瑞白升血处理）。自下次出院（2013-10-23）以来，患者一般情况保持良好；无发热，无恶心、呕吐，无明显反酸、嗳气，无明显进食不适，未现明显腹痛、腹胀。现患者为行规律性复查并完善相关后续辅助治疗而再至我科就诊，遂依情以“胃恶性肿瘤术后”收入院。目前患者精神及情绪状态良好，食欲、饮食好，夜间睡眠后；近期无明显体重变化。'
            }, {
                date: '22',
                name: 'CCKS2019',
                address: '患者3月前主因“腹痛3月”入院，入院后完善相关检查，排除手术禁忌症，于2016.04.26在全麻上行胃癌根治术（全胃切除+ ROUX-EN-Y重建），术程顺利，术后安返病房，术后经抗感染、抑酸、止血、化痰、静脉营养支持等治疗，，术后病理示：（胃大体）镜检为胃中至低分化腺癌，LAUREN，分型：混合型，浸润至胃壁浆膜层，并累及食管壁至外膜层；可见脉管内癌栓及神经束侵犯；网膜组织未见癌。远近切缘未见癌。15/31LN(+)。分期PT4AN3MO,IIIC期。 现患者术后恢复良好，为术后行第7程XELOX辅助化疗来我院就诊。起病以来，患者无头晕、头痛，无发热、咳嗽、咳痰、胸闷、胸痛，精神体力一般，食欲上降，睡眠一般，小便正常，体重较前上降2KG。'
            }, {
                date: '24',
                name: 'CCKS2019',
                address: '缘于入院前1余年前于我院诊为胃癌，于2012-08-07在全麻上行根治术全胃切除术。术后病理（201223223）示全胃：食管胃交界溃疡型管状腺癌，II-III级，侵出浆膜层，侵犯脉管和神经。手术标本下切端见癌浸润，手术标本上切端和另送（下切端）未见癌浸润。镜上找到贲门周淋巴结3/8个、小弯淋巴结3/4个、大弯淋巴结0/1个、幽门下淋巴结0/4个和幽门上淋巴结0/1个见癌转移。术后给予对症、营养支持等治疗，恢复良好,伤口愈合II/甲，并顺利出院，2012.09.24行“伊立替康280MG+替吉奥60MGBID×14D”方案化疗1周期，2012.10.23按“伊立替康280MG+替吉奥40MGBID×14D”方案化疗1周期，2012.11.20按“伊立替康240MG+替吉奥80MGBID×7D”化疗1次,2012.12.22按““安素泰210MG+艾奕40MGBID×14D”化疗1次，2013.1.18予“安素泰240MG+替吉奥40MGBID×14D”方案化疗1次，2013.02.23按T“安素泰240MG”方案化疗1周期。2014.08.28予“表柔比星70MGIVGTTD1+替吉奥40MGBID×10D”方案化疗1次。今为再次化疗就诊我院，门诊拟胃癌术后化疗后收入院。下次出院以来精神、睡眠、饮食可，无腹痛、腹胀、发热，大小便正常，体重较前无明显变化。'
            }],
            dialogTableVisible: false,


            kgechartInstance: null,
            formInline: {
                diseasename: '',
                entityclassuri: ''
            },
            valuemap:{
                "drugnodesbydisease" :"药物",
                "operationnodesbydisease": "手术",
                "bodynodesbydisease": "解剖部位",
                "checknodesbydisease": "影像检查",
                "testnodesbydisease": "实验室检验",
                "diseasenodesbydisease": "疾病与诊断"
            }
        }

    },

    methods: {

        select(row){
            console.log(row.date)
            this.$router.push({
                // path: '/textshow',
                path: '/ner',
                query:{
                    textId: row.date
                }
            })
        },

        initChart() {
            const _this = this
            this.kgechartInstance = this.$echarts.init(this.$refs.kgchart)
            var options = {
                textStyle: {
                    overflow: 'truncate'
                },
                animation:false,
                title: {
                    text: ''
                },
                tooltip: {},
                animationDurationUpdate: 1500,
                animationEasingUpdate: 'quinticInOut',
                label: {
                    normal: {
                        show: true,
                        textStyle: {
                            fontSize: 12,
                            color: '#000000'
                        },
                    }
                },
                legend: {
                    x: "center",
                    show: false,
                    data: ["1", "2", '3']
                },
                series: [
                    {
                        type: 'graph',
                        layout: 'force',
                        symbolSize: 60,
                        focusNodeAdjacency: true,
                        roam: true,
                        categories: [{
                            name: '1',
                            itemStyle: {
                                normal: {
                                    color: "#009800",
                                    fontSize: 50,
                                    textStyle: {
                                        fontSize: 120,
                                        width: 20,
                                        color: '#FFFFFF'
                                    },

                                }
                            }
                        }, {
                            name: '2',
                            itemStyle: {
                                normal: {
                                    color: "#4592FF",
                                    fontSize: 50,
                                    textStyle: {
                                        fontSize: 12,
                                        width: 20,
                                        color: '#FFFFFF'
                                    },
                                }
                            }
                        }, {
                            name: '4',
                            itemStyle: {
                                normal: {
                                    color: "#3592F",
                                    textStyle: {
                                        fontSize: 12,
                                        width: 20,

                                        color: '#FFFFFF'
                                    },
                                }
                            }
                        }],
                        // label: {
                        //     width: 5,
                        //     fontSize: 500,
                        //     normal: {
                        //         show: true,
                        //         fontSize: 50,
                        //         textStyle: {
                        //             width: 1,
                        //             // 只有这里fontsize有用
                        //             fontSize: 12,
                        //             maxWidth: 5,
                        //             overflow: 'truncate',
                        //
                        //         },
                        //     }
                        // },

                        label: {
                            show: true,
                            overflow: "truncate",
                            width: 50,
                            // color: '#FFFFFF',
                            normal:{
                                show: true,
                                textStyle:{
                                    color: '#FFFFFF',
                                    fontSize: 20
                                }
                            }
                        },
                        force: {
                            repulsion: 1000,
                            layoutAnimation: false
                        },
                        edgeSymbolSize: [4, 50],
                        edgeLabel: {
                            normal: {
                                show: true,
                                textStyle: {
                                    fontSize: 20,
                                    width: 20
                                },
                                formatter: "{c}"
                            }
                        },
                        data: [{
                            name: '节点0',
                            draggable: true,

                        }, {
                            name: '节点1',
                            category: 4,
                            draggable: true,

                        },],
                        links: [{
                            source: 0,
                            target: 1,
                            category: 0,
                            value: '0-1'
                        },],
                        lineStyle: {
                            normal: {
                                opacity: 0.9,
                                width: 1,
                                curveness: 0
                            }
                        }
                    }
                ]
            }
            this.kgechartInstance.setOption(options);
            this.kgechartInstance.on('click', {dataType: 'node'}, function (params){
                // MessageBox.alert(params.data.name, '实体名称', {
                //     confirmButtonText: '确定',
                //     callback: action => {
                //         this.$message({
                //             type: 'info',
                //             message: `action: ${ action }`
                //         });}
                // });

                _this.selectedName = params.data.name
                _this.dialogTableVisible=true
            })

        },
        getDiseaseDefaltData() {
            // this.getDiseaseData('diseasenodesbydisease', '胃癌')
            this.getOtherData('drugnodesbydisease', '胃癌')
        },
        getDiseaseData(entityclassuri, diseasename) {
            const _this = this
            axios.get("http://localhost:8082/" + entityclassuri + "/" +diseasename).then(function (reps) {
                // console.log(reps.data)
                var tmp_data = reps.data

                var option = []
                var links = []
                option.push({'name': diseasename, 'category': 0, 'draggable': true})
                var index = 0
                tmp_data.forEach(item => {
                    index += 1
                    // console.log(index)
                    let x = item.diseaseName
                    option.push({'name': x, 'category': 1, 'draggable': true})
                    links.push({
                        'source': 0,
                        'target': index,
                        'category': 1,
                        'value': _this.valuemap[entityclassuri]
                    })
                })

                // console.log(option)
                _this.kgechartInstance.setOption({
                    series: {
                        data: option,
                        links: links
                    }
                })
            })

        },
        getOtherData(entityclassuri, diseasename) {
            const _this = this
            axios.get("http://localhost:8082/" + entityclassuri + "/" + diseasename).then(function (reps) {
                console.log(reps.data)
                var tmp_data = reps.data

                var option = []
                var links = []
                option.push({'name': diseasename, 'category': 0, 'draggable': true})
                var index = 0
                tmp_data.forEach(item => {
                    index += 1
                    // console.log(index)
                    let x = item.entityContent
                    option.push({'name': x, 'category': 1, 'draggable': true})
                    links.push({
                        'source': 0,
                        'target': index,
                        'category': 1,
                        'value': _this.valuemap[entityclassuri]
                    })
                })

                console.log(option)
                _this.kgechartInstance.setOption({
                    series: {
                        data: option,
                        links: links
                    }
                })
            })

        },
        updateChart() {

        },
        onSubmit() {
            var uri = this.formInline.entityclassuri
            var name = this.formInline.diseasename
            if (this.valuemap[uri] == '疾病与诊断'){
                this.getDiseaseData(uri, name)
            }else {
                this.getOtherData(uri, name)
            }
        }

    },

    mounted() {
        this.initChart();
        this.getDiseaseDefaltData()
    }
}
</script>

<style scoped>

</style>
