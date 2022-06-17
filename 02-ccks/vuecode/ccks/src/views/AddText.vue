<template>
    <div>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

            <el-form-item label="病历名称" prop="textName">
                <el-input v-model="ruleForm.textName"></el-input>
            </el-form-item>
            <el-form-item label="内容" prop="textContent" >
                <el-input type="textarea" v-model="ruleForm.textContent" maxlength="512" :autosize="{ minRows: 10}"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>


<script>
export default {
    data() {
        return {
            ruleForm: {
                textId: null,
                textName: '',
                textContent: ''
            },
            rules: {
                textName: [
                    { required: true, message: '请输入名称', trigger: 'blur' },
                    { min: 3, max: 50, message: '长度在 3 到 50 个字符', trigger: 'blur' }
                ],
                textContent: [
                    { required: true, message: '请填写内容', trigger: 'blur' }
                ]
            }
        };
    },
    methods: {
        submitForm(formName) {
            const _this = this
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    axios.post("http://localhost:8081/cckstext/add", this.ruleForm).then(function (resp) {
                        console.log(resp)
                        if (resp.data == 'success'){
                            // alert('submit!');
                            _this.$router.push('/')
                        }


                    })

                } else {
                    console.log('error submit!!');
                    return false;
                }
            });
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        }
    }
}
</script>
