<template>
    <swiper class="swiper" :options="swiperOption" style="height: 500px">
        <swiper-slide class="back"><span style="font-size: 50px">惠医知识图谱系统</span></swiper-slide>
        <swiper-slide class="back">
            <div>
                <el-row>
                    <el-col :span="12">
                        <div id="main" style="width: 500px; height: 250px" ref="chart">
                        </div>
                    </el-col>
                    <el-col :span="12">
                        <div id="test" style="width: 600px; height: 250px" ref="entitychartbytextname"></div>
                    </el-col>
                </el-row>
                <el-row>
                    <!--            <el-col :span="8"><div id="main1" style="width: 400px; height: 250px"  ref="chart1"></div></el-col>-->
                    <el-col :span="12">
                        <div id="main2" style="width: 600px; height: 250px" ref="chart2"></div>
                    </el-col>
                    <el-col :span="12">
                        <div id="main3" style="width: 600px; height: 250px" ref="chart3"></div>
                    </el-col>
                </el-row>


            </div>
        </swiper-slide>
        <swiper-slide class="back">

            <div style="margin-top: 20px">
                <el-row :gutter="20">
                    <el-col :span="11">
                        <div id="echartsWordclouddisease" style="width:400px;height:400px;"></div>
                    </el-col>
                    <el-col :span="11" :offset="2">
                        <div id="echartsWordcloudentity" style="width:400px;height:400px;"></div>
                    </el-col>
                </el-row>
            </div>


        </swiper-slide>
        <div class="swiper-pagination" slot="pagination"></div>
    </swiper>
</template>


<script>

import * as echarts from 'echarts'
import 'echarts-wordcloud'

require('echarts-wordcloud')
import {Swiper, SwiperSlide} from 'vue-awesome-swiper'
import 'swiper/swiper-bundle.css'

import Swiper2, {Navigation, Pagination, Mousewheel} from 'swiper'

Swiper2.use([Navigation, Pagination, Mousewheel])
export default {
    name: 'swiper-example-mousewheel-control',
    title: 'Mousewheel control',
    components: {
        Swiper,
        SwiperSlide
    },
    data() {
        return {
            swiperOption: {
                direction: 'vertical',
                slidesPerView: 1,
                spaceBetween: 30,
                mousewheel: true,
                pagination: {
                    el: '.swiper-pagination',
                    clickable: true
                },
                observer: true,
                observeParents: true
            },

            chartInstance: null,
            allData: null,
            entityChart: null,
            entityData: null
        }
    },

    methods: {

        initWordCloud() {

            var diseasechart = this.$echarts.init(document.getElementById('echartsWordclouddisease'));

            diseasechart.setOption({
                series: [{
                    type: 'wordCloud',

                    // The shape of the "cloud" to draw. Can be any polar equation represented as a
                    // callback function, or a keyword present. Available presents are circle (default),
                    // cardioid (apple or heart shape curve, the most known polar equation), diamond (
                    // alias of square), triangle-forward, triangle, (alias of triangle-upright, pentagon, and star.

                    shape: 'circle',

                    // A silhouette image which the white area will be excluded from drawing texts.
                    // The shape option will continue to apply as the shape of the cloud to grow.

                    // maskImage: maskImage,

                    // Folllowing left/top/width/height/right/bottom are used for positioning the word cloud
                    // Default to be put in the center and has 75% x 80% size.

                    left: 'center',
                    top: 'center',
                    width: '100%',
                    height: '100%',
                    right: null,
                    bottom: null,

                    // Text size range which the value in data will be mapped to.
                    // Default to have minimum 12px and maximum 60px size.

                    sizeRange: [12, 60],

                    // Text rotation range and step in degree. Text will be rotated randomly in range [-90, 90] by rotationStep 45

                    rotationRange: [-30, 30],
                    rotationStep: 45,

                    // size of the grid in pixels for marking the availability of the canvas
                    // the larger the grid size, the bigger the gap between words.

                    gridSize: 8,

                    // set to true to allow word being draw partly outside of the canvas.
                    // Allow word bigger than the size of the canvas to be drawn
                    drawOutOfBound: false,

                    // If perform layout animation.
                    // NOTE disable it will lead to UI blocking when there is lots of words.
                    layoutAnimation: true,


                    // Global text style
                    textStyle: {
                        fontFamily: 'sans-serif',
                        fontWeight: 'bold',
// Color can be a callback function or a color string
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    },


                    // Data is an array. Each array item must have name and value property.
                    data: [{
                        name: '胃癌',
                        value: 366,
                        // Style of single text
                        "textStyle": {
                            "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                Math.round(Math.random() * 160).toString(16) +
                                Math.round(Math.random() * 160).toString(16)
                        }

                    },
                        {
                            name: '胃癌晚期',
                            value: 3,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '肝癌',
                            value: 6,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '食道癌',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '脑癌',
                            value: 36,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '结肠癌术后',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '贲门腺癌（中度分化），浸润溃疡型',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '直肠癌术后吻合口瘘',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '多发性增生性（锯齿状）息肉',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '脑梗死',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '脑梗死后遗症',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '短暂性脑缺血发作',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '高血压病',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '高脂血症',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '2型糖尿病',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '脑萎缩',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '两侧筛窦炎',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '胆囊肿大',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '左肾结石',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '颈动脉粥样硬化',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '贲门癌',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                    ],


                }]
            });

            var entitychart = this.$echarts.init(document.getElementById('echartsWordcloudentity'));

            entitychart.setOption({
                series: [{
                    type: 'wordCloud',
                    shape: 'circle',
                    left: 'center',
                    top: 'center',
                    width: '100%',
                    height: '100%',
                    right: null,
                    bottom: null,
                    sizeRange: [12, 60],
                    rotationRange: [-30, 30],
                    rotationStep: 45,
                    gridSize: 8,
                    drawOutOfBound: false,
                    layoutAnimation: true,
                    textStyle: {
                        fontFamily: 'sans-serif',
                        fontWeight: 'bold',
// Color can be a callback function or a color string
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    },
                    data: [{
                        name: '奥沙利铂',
                        value: 366,
                        // Style of single text
                        "textStyle": {
                            "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                Math.round(Math.random() * 160).toString(16) +
                                Math.round(Math.random() * 160).toString(16)
                        }

                    },
                        {
                            name: '卡培他滨',
                            value: 3,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '亚叶酸钙',
                            value: 6,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '替加氟',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '氟尿嘧啶',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '北华素',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '波贝',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '乐沙定',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '希罗达',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '表柔比星',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: 'S-1',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: 'OXA',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '伊立替康',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '华法林',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '吉西他滨',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '顺铂',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '紫杉醇',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },
                        {
                            name: '头孢呋辛',
                            value: Math.floor(Math.random() * (500 - 50)) + 50,
                            // Style of single text
                            "textStyle": {
                                "color": "#" + Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16) +
                                    Math.round(Math.random() * 160).toString(16)
                            }

                        },],


                }]
            });

        },
        myEcharts() {
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
                    data: ['销量']
                },
                xAxis: {
                    data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"]
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

        initChart() {
            this.chartInstance = this.$echarts.init(this.$refs.chart)
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
                    text: '年度病例实体数量'
                },
                xAxis: {
                    type: 'category',
                    data: names
                },
                yAxis: {
                    type: 'value'
                },
                series: {
                    type: 'bar',
                    data: countValue,
                    barWidth: '20%'
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
                    text: '病例实体数量分布'
                },
                xAxis: {
                    type: 'category',
                    data: ['疾病和诊断', '解剖部位', '影像检查', '实验室检验', '手术', '药物']
                    // data: entitynames
                },
                yAxis: {
                    type: 'value'
                },
                series: {
                    type: 'bar',
                    data: entitycountValue,
                    barWidth: '20%'
                }
            }
            this.entityChart.setOption(entityoption)

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

.back {
    background-image: url("C:\\Users\\Administrator\\Desktop\\1.jpeg");
    background-repeat: no-repeat;
    background-size: cover;

    filter: alpha(Opacity=85);
    -moz-opacity: 0.85;
    opacity: 0.85;
}

.el-row {
    margin-bottom: 20px;

    &:last-child {
        margin-bottom: 0;
    }
}
</style>
