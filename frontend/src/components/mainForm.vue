<template>
  <div id="app" align="center" class="mainform">
	<img alt="Sport logo" src="../assets/sport_logo.png">
	<h3>SportsTraining</h3>
    <button class="btn" v-on:click="btLogin()">Войти</button>

	<!--Удалить позже, для быстрого открывания таблиц-->
	<hr>
	<div class="row">
    <button class="btn" v-on:click="Section()">Секция</button>
	<button class="btn" v-on:click="Trainer()">Тренер</button>
	<button class="btn" v-on:click="Schedule()">Расписание</button>
	<button class="btn" v-on:click="HS()">Заголовки</button>
	<button class="btn" v-on:click="Place()">Места</button>
	<button class="btn" v-on:click="Learner()">Ученики</button>
	</div>
  </div>
</template>

<script>
export default {
	methods: {
		Section() {
			this.$router.push(`/sections`);
		},
		Trainer() {
			this.$router.push(`/trainers`);
		},
		Place() {
			this.$router.push(`/places`);
		},
		HS() {
			this.$router.push(`/headerschedules`);
		},
		Learner() {
			this.$router.push(`/learners`);
		},
		Schedule() {
			this.$router.push(`/schedules`);
		},
		
	}
}
</script>

