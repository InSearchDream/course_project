<template>
  <div class="container">
  <main-header/>
    <h3>Данные обо всех учениках</h3>
	<b-row>
		<b-col md="3">
			<b-form-input v-model="filter" type="search" placeholder="Найти"> </b-form-input>
		</b-col>
	</b-row>
	<b-row>
		<b-col>
			<b-table		
			striped
			hover
			:items="learners"
			:per-page="perPage"
			:current-page="currentPage"
			:filter="filter"
			:fields="fields">
			<template v-slot:cell(Update)="data">
				<b-button variant="btn" @click="updateLearner(data.item[0].id_learner)">Δ</b-button>
			</template>
			<template v-slot:cell(Delete)="data">
				<b-button variant="btn" @click="deleteLearner(data.item[0].id_learner)">-</b-button>
			</template>
			</b-table>
			<b-pagination
			class="pagination"
			v-model="currentPage"
			:total-rows="rows"
			:per-page="perPage"
			></b-pagination>
		</b-col>
	</b-row>
	<div class="row">
        <button class="btn" v-on:click="addLearner()">Добавить</button>
    </div>
  </div>
</template>

<script>
import LearnerDataService from "../service/DataService";
import MainHeader from "@/components/MainHeader";

export default {
  name: "Trainers",
  components: {MainHeader},
  data() {
    return {
      fields: [
		//{key: 'id_learner', label: "ИД"}, 
		{key: '0.last_name', label: "Фамилия"/*, sortable: true, sortDirection: 'desc'*/ },
		{key: '0.first_name', label: "Имя"}, 
		{key:"0.middle_name", label: "Отчество"},
		{key:"0.phone", label: "Телефон"},
		{key:"0.birthday", label: "Дата рождения"},
		//{key:"id_section", label: "Секция"},
		{key:"1.section_name", label: "Секция"},
		{key:"0.enrolled", label: "Зачислен"},
		{key:"Update",label: "Update"},
		{key:"Delete", label: "Delete"}],           	  
      learners: [],
      filter: "",
      message: "",
      perPage: 5,
      currentPage: 1,	
    };
  },
  methods: {
    refreshLearners() {
      LearnerDataService.retrieveAllLearners().then((res) => {
        this.learners = res.data;
      });
    },
    addLearner() {
      this.$router.push(`/learners/-1`);
    },
    updateLearner(id_learner) {
      this.$router.push(`/learners/${id_learner}`);
    },
    deleteLearner(id_learner) {
      LearnerDataService.deleteLearner(id_learner).then(() => {
        this.refreshLearners();
      });
    },
  },
  computed: {
      rows() {
        return this.learners.length
      }
  },
  created() {
    this.refreshLearners();
  },
};
</script>
<!--<template>
  <div class="container">
  <main-header/>
    <h3>Данные обо всех учениках</h3>
    <div v-if="message" class="alert alert-success">{{ this.message }}</div>
    <div class="container">
      <table class="table">
        <thead>
          <tr>           
            <th>Фамилия</th>
			<th>Имя</th>
			<th>Отчество</th>
            <th>Телефон</th>
            <th>Дата рождения</th>
			<th>Секция</th>
			<th>Зачислен</th>
			<th>Обновить</th>
			<th>Удалить</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="learner in learners" v-bind:key="learner.id_learner">          
            <td>{{ learner.last_name }}</td>
			<td>{{ learner.first_name }}</td>
			<td>{{ learner.middle_name }}</td>
            <td>{{ learner.phone }}</td>
            <td>{{ learner.birthday }}</td>
			<td>{{ learner.id_section }}</td>
            <td>{{ learner.enrolled }}</td>
			<td>
              <button class="btn" v-on:click="updateLearner(learner.id_learner)">
                Update
              </button>
            </td>
            <td>
              <button class="btn" v-on:click="deleteLearner(learner.id_learner)">
                Delete
              </button>
            </td>
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
import MainHeader from "@/components/MainHeader";

export default {
  name: "Learners",
  components: {MainHeader},
  data() {
    return {
      learners: [],
      message: "",
    };
  },
  methods: {
    refreshLearners() {
      LearnerDataService.retrieveAllLearners().then((res) => {
        this.learners = res.data;
      });
    },
    addLearner() {
      this.$router.push(`/learners/-1`);
    },
    updateLearner(id_learner) {
      this.$router.push(`/learners/${id_learner}`);
    },
    deleteLearner(id_learner) {
      LearnerDataService.deleteLearner(id_learner).then(() => {
        this.refreshLearners();
      });
    },
  },
  created() {
    this.refreshLearners();
  },
};
</script>-->
