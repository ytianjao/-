<template>
    <div>
        <el-row>
            <el-col :span="12"><div id="main" style="width: 500px; height: 250px"  ref="chart">
            </div></el-col>
            <el-col :span="12"><div id="test" style="width: 600px; height: 250px" ref="entitychartbytextname"></div></el-col>
        </el-row>
        <el-row>
<!--            <el-col :span="8"><div id="main1" style="width: 400px; height: 250px"  ref="chart1"></div></el-col>-->
            <el-col :span="12"><div id="main2" style="width: 600px; height: 250px"  ref="chart2"></div></el-col>
            <el-col :span="12"><div id="main3" style="width: 600px; height: 250px"  ref="chart3"></div></el-col>
        </el-row>


    </div>
</template>

<script>
export default {
    name: "chart_test",
    data(){
        return{
            chartInstance: null,
            // chartInstance1: null,
            chartInstance2: null,
            chartInstance3: null,
            allData: null,
            entityChart: null,
            entityData: null
        }
    },
    methods: {
        initChart() {
            this.chartInstance = this.$echarts.init(this.$refs.chart)
            // this.chartInstance1 = this.$echarts.init(this.$refs.chart1)
            this.chartInstance2 = this.$echarts.init(this.$refs.chart2)
            this.chartInstance3 = this.$echarts.init(this.$refs.chart3)
            this.entityChart = this.$echarts.init(this.$refs.entitychartbytextname)
        },
        getData() {
            const _this = this
            axios.get('http://localhost:8081/count/text2').then(function (resp) {
                // console.log(resp.data)
                _this.allData = resp.data
                _this.updateChart()
            })
            axios.get('http://localhost:8081/entity/countall3').then(function (resp) {
                console.log(resp.data)
                _this.entityData = resp.data
                _this.updateChart()
            })

            // this.updateChart()
        },
        updateChart() {
            const names = this.allData.map((item) => {
                return item.name
            })
            const countValue = this.allData.map((item) => {
                return item.value
            })
            const option = {
                title: {
                    text: '电子病历实体数量统计'
                },
                xAxis: {
                    type: 'category',
                    // data: names,
                    data:['CCKS2018', 'CCKS2019', 'CCKS2020'],
                    // min:2,
                    // max:5
                },
                yAxis: {
                    type: 'value'
                },
                series: {
                    type: 'bar',
                    data: countValue,

                    barWidth:'30%',
                }
            }
            this.chartInstance.setOption(option)



            const entitynames = this.entityData.map((item) => {
                return item.name
            })
            const entitycountValue = this.entityData.map((item) => {
                return item.value
            })
            const entityoption = {
                title: {
                    text: 'CCKS2020实体数量分布'
                },
                xAxis: {
                    type: 'category',
                    data:['疾病和诊断', '解剖部位', '影像检查', '实验室检验', '手术','药物'],
                    nameGap: 5
                    // data: entitynames
                },
                yAxis: {
                    type: 'value'
                },
                series: {
                    type: 'bar',
                    data: entitycountValue,
                    barWidth:'20%'
                }
            }
            this.entityChart.setOption(entityoption)
            // this.chartInstance1.setOption(entityoption)
            const modeloption2 = {
                title: {
                    text: 'CCKS2019模型性能'
                },
                xAxis: {
                    type: 'category',
                    data:['疾病和诊断', '解剖部位', '影像检查', '实验室检验', '手术','药物'],
                    nameGap: 5
                    // data: entitynames
                },
                yAxis: {
                    type: 'value'
                },
                legend: {
                    data: ['BERT', 'XLNET','模型融合']
                },
                series:[
                    {
                        name: 'BERT',
                        type: 'bar',
                        // data: entitycountValue,
                        data: ['82.18','89.49','80.31','84.86','83.62','90.7'],
                        barWidth:'20%'
                    },
                    {
                        name: 'XLNET',
                        type: 'bar',
                        data: ['79.41','87.58','79.4','89.95','88.34','89.18'],
                        barWidth:'20%'
                    },
                    {
                        name: '模型融合',
                        type: 'bar',
                        data: ['86.78','86.57','88.64','90.36','88.13','96.07'],
                        barWidth:'20%'
                    }
                ]
            }
            const modeloption3 = {
                title: {
                    text: 'CCKS2020模型性能'
                },
                xAxis: {
                    type: 'category',
                    data:['疾病和诊断', '解剖部位', '影像检查', '实验室检验', '手术','药物'],
                    nameGap: 5
                    // data: entitynames
                },
                yAxis: {
                    type: 'value'
                },
                legend: {
                    data: ['BERT', 'XLNET','模型融合']
                },
                series:[
                    {
                        name: 'BERT',
                        type: 'bar',
                        // data: entitycountValue,
                        data: ['79.19','82.28','79.8','86.59','84','91.63'],
                        barWidth:'20%'
                    },
                    {
                        name: 'XLNET',
                        type: 'bar',
                        data: ['79.69','82.1','80.4','90.2','83.71','90.48'],
                        barWidth:'20%'
                    },
                    {
                        name: '模型融合',
                        type: 'bar',
                        data: ['87.88','87.67','89.74','91.46','89.23','97.17'],
                        barWidth:'20%'
                    }
                ]
            }
            this.chartInstance2.setOption(modeloption2)
            this.chartInstance3.setOption(modeloption3)

        }
    },
    mounted() {

        this.initChart();
        // this.myEcharts();
        this.getData();
        this.initWordCloud()
    }
}
</script>

<style lang="scss" scoped>
@import './base.scss';
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
    min-height: 36px;
}
.row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
}
</style>
