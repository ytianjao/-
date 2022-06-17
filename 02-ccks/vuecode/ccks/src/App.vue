<template>
    <div>
        <el-container style=" border: 1px solid #eee">

            <el-header style="">

                <el-menu
                    :default-active="activeIndex2"
                    class="el-menu-demo"
                    mode="horizontal"
                    @select="handleSelect"
                    background-color="#545c64"
                    text-color="#fff"
                    active-text-color="#ffd04b">
                    <el-menu-item style="margin-left: 40px" index="1">
                        <el-link href="/" type="primary" style="">主页</el-link>
                    </el-menu-item>
                    <el-menu-item style="margin-left: 80px" index="2">
                        <el-link href="/table" type="primary" style="">电子病历库</el-link>
                    </el-menu-item>
                    <el-menu-item style="margin-left: 80px" index="3">
                        <el-link href="/kgtest" type="primary" style="">医疗知识图谱</el-link>
                    </el-menu-item>
                    <el-menu-item style="margin-left: 80px" index="4">
                        <el-link href="/knowquestion" type="primary" style="">知识问答</el-link>
                    </el-menu-item>
                    <el-menu-item style="margin-left: 80px" index="5">
                        <el-link href="/ner" type="primary" style="">医疗实体识别</el-link>
                    </el-menu-item>
                    <el-menu-item style="margin-left: 80px" index="6">
                        <el-link href="/textmanage" type="primary" style="">实体标注众包</el-link>
                    </el-menu-item>
                </el-menu>

            </el-header>


            <el-container style="">

                <el-main class="back">

                    <router-view>

                    </router-view>
                </el-main>

            </el-container>
        </el-container>
    </div>
</template>


<style>


.el-main {
    /*position: absolute;*/
    overflow-y: scroll;
}

.el-aside {
    color: #333;
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


</style>

<script>
export default {
    data() {
        const item = {
            date: '2016-05-02',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1518 弄'
        };
        return {
            url: 'C:\\Users\\Administrator\\Desktop\\微信图片_20210615101746.png',
            tableData: Array(5).fill(item)
        }
    }
};


</script>


