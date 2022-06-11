<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
<!--    <HelloWorld msg="Welcome to Your Vue.js App"/>-->
      <biaoge></biaoge>
  </div>
</template>

<script>
// @ is an alias to /src
import biaoge from "@/components/biaoge";

export default {
  name: 'Home',
  components: {
      biaoge
  }
}
</script>
