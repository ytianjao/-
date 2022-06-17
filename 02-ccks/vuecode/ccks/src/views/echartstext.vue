<template>
    <div class="Echarts">
        <el-row :gutter="20">
            <el-col :span="6">
                <div id="main" style="width: 300px;height:400px;" ref="chart"></div>
            </el-col>
            <el-col :span="12">
                <div id="test" style="width: 600px;height:400px;" ref="entitychartbytextname"></div>
            </el-col>
        </el-row>


    </div>
</template>

<script>
export default {
    data(){
        return {
            chartInstance: null,
            allData: null,
            entityChart: null,
            entityData: null
        }
    },
    name: 'Echarts',
    methods:{
        myEcharts(){
            // 基于准备好的dom，初始化echarts实例
            // var myChart = this.$echarts.init(document.getElementById('main'));
            var myChart = this.$echarts.init(this.$refs.chart);

            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: 'ECharts 入门示例'
                },
                tooltip: {},
                legend: {
                    data:['销量']
                },
                xAxis: {
                    data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
                },
                yAxis: {},
                series: [{
                    name: '销量',
                    type: 'bar',
                    data: [5, 20, 36, 10, 10, 20]
                }]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        },

        initChart(){
            this.chartInstance = this.$echarts.init(this.$refs.chart)
            this.entityChart = this.$echarts.init(this.$refs.entitychartbytextname)
        },
        getData(){
            const _this = this
            axios.get('http://localhost:8081/count/text2').then(function (resp) {
                console.log(resp.data)
                _this.allData = resp.data
                _this.updateChart()
            })
            axios.get('http://localhost:8081/entity/countall2').then(function (resp) {
                console.log(resp.data)
                _this.entityData = resp.data
                _this.updateChart()
            })
            // this.updateChart()
        },
        updateChart(){
            const names = this.allData.map((item) => {
                return item.name
            })
            const countValue = this.allData.map((item) => {
                return item.value
            })
            const option = {
                xAxis: {
                    type: 'category',
                    data: names
                },
                yAxis: {
                    type: 'value'
                },
                series: {
                    type: 'bar',
                    data: countValue
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
                xAxis: {
                    type: 'category',
                    data: entitynames
                },
                yAxis: {
                    type: 'value'
                },
                series: {
                    type: 'bar',
                    data: entitycountValue
                }
            }
            this.entityChart.setOption(entityoption)
        }

    },
    mounted() {
        // this.myEcharts();
        this.initChart();
        this.getData()
    }
}
</script>

<style>

</style>
