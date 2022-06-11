<template>
  <div id="app">

    <biaoge></biaoge>
  </div>
</template>

<script>
import biaoge from "@/components/biaoge2";

export default {
  name: 'app',
  components: {
    biaoge
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
