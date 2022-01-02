<template>
  <div id="app" align="center">
    <img alt="Sport logo" src="./assets/sport_logo.png">
    <mainForm msg = "SportsTraining"/>
  </div>
</template>

<script>
import mainForm from './components/mainForm.vue'

export default {
  name: 'App',
  components: {
    mainForm
  }
}
</script>

<style>
	@import "style.css";
</style>

