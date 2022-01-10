<template>
  <div class="container">
    <h3>Данные о зачисленных в секции учениках</h3>
    <div v-if="message" class="alert alert-success">{{ this.message }}</div>
    <div class="container">
      <table class="table">
        <thead>
          <tr>           
            <th>Фамилия</th>
			<th>Имя</th>
			<th>Отчество</th>
            <th>Дата рождения</th>
			<th>Секция</th>
			<th>Зачислен</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="learner in learners" v-bind:key="learner.id_learner">          
            <td>{{ learner.last_name }}</td>
			<td>{{ learner.first_name }}</td>
			<td>{{ learner.middle_name }}</td>
            <td>{{ learner.birthday }}</td>
			<td>{{ learner.id_section }}</td>
            <td>{{ learner.enrolled }}</td>
          </tr>
        </tbody>
      </table>
      <div class="row">
        <button class="btn" v-on:click="addLearner()">Добавить</button>
      </div>
    </div>
  </div>
</template>
<script>
import LearnerDataService from "../service/DataService";

export default {
  name: "Learners",
  data() {
    return {
      learners: [],
      message: "",
    };
  },
  methods: {
    refreshLearners() {
      LearnerDataService.retrieveEnrolledLearners().then((res) => {
        this.learners = res.data;
      });
    },
    addLearner() {
      this.$router.push(`/learner/-1`);
    },
  },
  created() {
    this.refreshLearners();
  },
};
</script>