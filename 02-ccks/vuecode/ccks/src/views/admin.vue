<template >
    <div style="position: fixed; right: 0; left: 0; padding-right:0 !important">
        <!--        default-expand-all-->

        <!--        :tree-props="{children: 'children', hasChildren: 'hasChildren'}"-->

        <el-button @click="yingyong" type="primary" style="position: absolute; right: 20px; top: 10px; z-index: 10">应用最高人次标注</el-button>


        <el-table
            :data="tableData"
            style="width: 100%;margin-bottom: 20px;"
            row-key="id"
            border
            height="500px"
        >
            <el-table-column type="expand">
                <template slot-scope="scope">
                    <el-table :data="scope.row.child"
                              :row-class-name="tableRowClassName">
                        <el-table-column
                            prop="date"
                            label="实体编号"
                            width="180">
                        </el-table-column>
                        <el-table-column
                            prop="name"
                            label="实体类别"
                            width="180">
                        </el-table-column>

                        <el-table-column
                            prop="children"
                            width="680">

                        </el-table-column>
                        <el-table-column width="120">
                            <template slot-scope="scope1">
                                <el-button @click="showdialog(scope1.row)" type="primary">
                                    指定标注
                                </el-button>
                            </template>

                        </el-table-column>
                    </el-table>
                </template>

            </el-table-column>
            <el-table-column
                prop="date"
                label="病例编号"
                sortable
                width="180">
            </el-table-column>

            <el-table-column
                prop="address"
                label="病例文本">
            </el-table-column>
        </el-table>

        <el-dialog
            title="指定要选择的实体标注"
            :visible.sync="dialogVisible"
            width="30%"
            append-to-body
            >
            <span>111</span>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
            </span>
        </el-dialog>

    </div>
</template>
<script>
export default {
    data() {
        return {
            entityList:[],
            dialogVisible: false,
            label: '',
            tableData: [
                {
                    id: 1,
                    date: '病例编号01',
                    name: '',
                    address: '，患者3月前因“直肠癌”于在我院于全麻上行直肠癌根治术（DIXON术），手术过程顺利，术后给予抗感染及营养支持治疗，患者恢复好，切口愈合良好。，术后病理示：直肠腺癌（中低度分化），浸润溃疡型，面积3.5*2CM，侵达外膜。双端切线另送“近端”、“远端”及环周底部切除面未查见癌。肠壁一站（10个）、中间组（8个）淋巴结未查见癌。，免疫组化染色示：ERCC1弥漫（+）、TS少部分弱（+）、SYN（-）、CGA（-）。术后查无化疗禁忌后给予3周期化疗，，方案为：奥沙利铂150MG D1，亚叶酸钙0.3G+替加氟1.0G D2-D6，同时给与升白细胞、护肝、止吐、免疫增强治疗，患者副反应轻。院外期间患者一般情况好，无恶心，无腹痛腹胀胀不适，无现患者为行复查及化疗再次来院就诊，门诊以“直肠癌术后”收入院。   近期患者精神可，饮食可，大便正常，小便正常，近期体重无明显变化。',
                    child: [
                        {
                            id: 2,
                            date: '实体编号01',
                            name: '解剖部位',
                            address: '上海市普陀区金沙江路 1519 弄',
                            // options: [
                            //     {
                            //         value: '默认',
                            //         label: '直肠癌'
                            //     },
                            // ]

                            children: [
                                '直肠癌：提交人次4864人'
                            ]
                        },
                        {
                            id: 3,
                            date: '实体编号02',
                            name: '疾病与诊断',
                            address: '上海市普陀区金沙江路 1519 弄',
                            children: [
                                '全麻上行直肠癌根治术（DIXON术）：提交人次48674人； ',
                                '全直肠癌根治术（DIXON术）：提交人次465人； ',
                                '全麻上行直肠癌根治术：提交人次453人； '
                            ]
                        },
                        {
                            id: 4,
                            date: '实体编号03',
                            name: '疾病与诊断',
                            address: '上海市普陀区金沙江路 1519 弄',
                            children: [
                                '直肠腺癌（中低度分化），浸润溃疡型：提交人次456人；',
                                '直肠腺癌（中低度分化）：提交人次46人；',
                                '直肠腺癌：提交人次16人；'
                            ],
                            options: [
                                {
                                    value: '默认',
                                    label: '直肠腺癌（中低度分化），浸润溃疡型'
                                },

                                {
                                    value: '提交人次456人',
                                    label: '直肠腺癌（中低度分化）'
                                },

                                {
                                    value: '提交人次46人',
                                    label: '直肠腺癌'
                                },
                            ]
                        },
                        {
                            id: 5,
                            date: '实体编号04',
                            name: '解剖部位',
                            address: '上海市普陀区金沙江路 1519 弄',
                            children: [
                                '肠：提交人次4863人；',
                                '肠壁：提交人次4156人'
                            ],
                        },
                        {
                            id: 6,
                            date: '实体编号05',
                            name: '药物',
                            address: '上海市普陀区金沙江路 1519 弄',
                            children: [
                                '奥沙利铂：提交人次14586人'
                            ]
                        },
                    ]
                },

                {
                    id: 4,
                    date: '病例编号02',
                    name: '王小虎',
                    address: '患者于6月前因“解稀烂便”完善检查发现结肠癌伴肝转移，2月2日行结肠癌手术切除，手术顺利，术后行FOLFOX方案化疗2程。2月前复查CT发现肝内病灶较前进展，故于2012-4-17、5-3予以FOLFIRI化疗2程，过程顺利。复查CT提示肝脏病变较前增大，考虑PD。故予FOLFIRI＋AVASTIN方案化疗3程，过程顺利。今日为求进一步诊治来我院。患者发病以来,无症状。精神佳,饮食睡眠佳,大小便正常，体重无减轻。',
                    child: [
                        {
                            id: 5,
                            date: '2016-05-01',
                            name: '王小虎',
                            address: '上海市普陀区金沙江路 1519 弄'
                        },
                        {
                            id: 6,
                            date: '2016-05-01',
                            name: '王小虎',
                            address: '上海市普陀区金沙江路 1519 弄'
                        },
                    ]
                },

                {
                    id: 7,
                    date: '病例编号03',
                    name: '王小虎',
                    address: '，患者于1月前因“反复中下腹闷痛不适3月”入院，诊为胃癌，于2013年12月10日在全麻上行根治性全胃切除术+食管空肠ROUX-Y吻合术（D2），手术顺利。术中见腹腔内无明显粘连，无明显腹水，盆腔、腹壁、大网膜无明显转移结节，肝脏表面光滑，未见明显转移灶，肿瘤位于贲门胃体下段小弯侧，侵出浆膜层，活动度可，周围可及明显肿大淋巴结，主要位于胃小弯侧及胃右动脉旁。术后病理（201339038），：（全胃），：食管胃交界溃疡型低分化腺癌，侵出浆膜层，侵犯神经，脉管内见癌栓，手术标本下、上切端及另送（下切端）均未见癌浸润，找到贲门左淋巴结1/2个，小弯淋巴结5/11个，大弯淋巴结0/1个，幽门上淋巴结0/3个，及另送的（胃右动脉根部）淋巴结2/5个见癌转移。另送（脾门淋巴结）为纤维、脂肪组织。术后给予对症、抗感染治疗，恢复良好,伤口愈合II/甲。此次为术后第1次化疗入院。患者出院后饮食、夜休可，无腹痛、腹胀、发热，体重较前无明显变化。',
                    child: [
                        {
                            id: 8,
                            date: '2016-05-01',
                            name: '王小虎',
                            address: '上海市普陀区金沙江路 1519 弄'
                        },
                        {
                            id: 9,
                            date: '2016-05-01',
                            name: '王小虎',
                            address: '上海市普陀区金沙江路 1519 弄'
                        },
                    ]
                },

                {
                    id: 10,
                    date: '病例编号04',
                    name: '王小虎',
                    address: '，患者3月前因“反复腹痛、腹泻10余天，加重3天”入院，于2016-03-18在全麻上行乙状结肠部分切除+乙状结肠单腔造瘘术，手术过程顺利。，术后病理：结肠腺癌（中度分化），浸润溃疡型，体积5*4*0.9CM，侵达浆膜脂肪组织。双端切线及环周底部切除面未查见癌。肠壁一站（8/14个）淋巴结癌转移。符合结肠炎性息肉。，免疫组化染色示癌组织：SYN（-）、TS弱（+）。2月前患者造口旁出现可复性肿物，站立和用力后增大，平卧后可以回纳消失，伴造口脱垂及肠粘膜渗血，现患者为求进一步诊治，门诊以“造口旁疝”收入我科。   患者精神欠佳，普通饮食，大小便正常，体重较前无明显变化。',
                    child: [
                        {
                            id: 11,
                            date: '2016-05-01',
                            name: '王小虎',
                            address: '上海市普陀区金沙江路 1519 弄'
                        },
                        {
                            id: 12,
                            date: '2016-05-01',
                            name: '王小虎',
                            address: '上海市普陀区金沙江路 1519 弄'
                        },
                    ]

                },

                {
                    id: 13,
                    date: '病例编号05',
                    name: '王小虎',
                    address: '，患者于2015年5月26日在我院行腹腔镜检查+卵巢肿瘤活检术。，术后病理学检查报告：(左卵巢)破碎卵巢组织见部分异型性腺体和分化较低的片巢状细胞，局灶伴鳞状下皮化生，符合恶性肿瘤，考虑为腺癌。于5月30日给予TP方案化疗（紫杉醇（特素）240MG静脉滴注，顺铂90MG腹腔灌注）。于７月３日在全麻上经腹行全子宫切除术+两侧附件切除术+大网膜部分切除术+阑尾切除术。，术后病检示：1、（左卵巢）中-低分化浆液性乳头状腺癌，同侧输卵管未见癌累及。右卵巢见癌转移，右输卵管、子宫未见癌转移。阑尾未见癌转移。大网膜见癌转移。2、子宫平滑肌瘤。于７月１３日行紫杉醇（泰素）240MG静脉滴注＋顺铂90MG灌腹，8月14日行紫杉醇（泰素）240MG+顺铂100MG静脉滴注化疗，9月19日、10月21日、11月19日、12月19日行紫杉醇（泰素）240MG+奥沙利铂200MG化疗。化疗过程中，患者有恶心、呕吐、脱发等症状，化疗结束后缓解。入院前20天，患者于我科门诊复查，门诊给予“华蟾素片”治疗，自诉用药后患者感腹痛、腹胀，尚能忍受，无腹泻、恶心、呕吐等。因腹痛持续，患者遂于今日来院。门诊以“第六次化疗后、卵巢浆液性乳头状腺癌IIIC期”收住入院。U0004   患者本次发病以来，食欲正常， 神志清醒，精神尚可，睡眠尚可，大便正常，小便正常，体重无明显变化。',
                    child: [{
                        id: 14,
                        date: '2016-05-01',
                        name: '王小虎',
                        address: '上海市普陀区金沙江路 1519 弄'
                    }, {
                        id: 15,
                        date: '2016-05-01',
                        name: '王小虎',
                        address: '上海市普陀区金沙江路 1519 弄'
                    }]
                },
                {
                    id: 16,
                    date: '病例编号06',
                    name: '王小虎',
                    address: '患者于6月前因“解稀烂便”完善检查发现结肠癌伴肝转移，2月2日行结肠癌手术切除，手术顺利，术后行FOLFOX方案化疗2程。2月前复查CT发现肝内病灶较前进展，故于2012-4-17、5-3予以FOLFIRI化疗2程，过程顺利。复查CT提示肝脏病变较前增大，考虑PD。故予FOLFIRI＋AVASTIN方案化疗3程，过程顺利。今日为求进一步诊治来我院。患者发病以来,无症状。精神佳,饮食睡眠佳,大小便正常，体重无减轻。',
                    child: [{
                        id: 17,
                        date: '2016-05-01',
                        name: '王小虎',
                        address: '上海市普陀区金沙江路 1519 弄'
                    }, {
                        id: 18,
                        date: '2016-05-01',
                        name: '王小虎',
                        address: '上海市普陀区金沙江路 1519 弄'
                    }]
                },
            ],
            tableData1: [{
                id: 1,
                date: '2016-05-02',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1518 弄'
            }, {
                id: 2,
                date: '2016-05-04',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1517 弄'
            }, {
                id: 3,
                date: '2016-05-01',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1519 弄',
                hasChildren: true
            }, {
                id: 4,
                date: '2016-05-03',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1516 弄'
            }]
        }
    },
    methods: {

        yingyong(){
            this.$alert('共有67条实体应用最高人次标注', '应用成功', {
                confirmButtonText: '确定',

            });
        },
        showdialog(row){
            // console.log(row.children)
            console.log(row.children[0].split('：'))
            this.dialogVisible = true
        },
        tableRowClassName({row, rowIndex}) {
            if (rowIndex === 1) {
                return 'warning-row';
            } else if (rowIndex === 3) {
                return 'success-row';
            }
            return '';
        },

        load(tree, treeNode, resolve) {
            setTimeout(() => {
                resolve([
                    {
                        id: 31,
                        date: '2016-05-01',
                        name: '王小虎',
                        address: '上海市普陀区金沙江路 1519 弄'
                    }, {
                        id: 32,
                        date: '2016-05-01',
                        name: '王小虎',
                        address: '上海市普陀区金沙江路 1519 弄'
                    }
                ])
            }, 1000)
        }
    }
    ,
}
</script>
