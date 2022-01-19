<template>
  <div class="container">
  <main-header/>
    <h3>Данные о тренерах</h3>
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
			:items="trainers"
			:per-page="perPage"
			:current-page="currentPage"
			:filter="filter"
			:fields="fields">
			<template v-if="$keycloak.hasRealmRole('editTrainer')" v-slot:cell(Update)="data">
				<b-button variant="btn" @click="updateTrainer(data.item.id_trainer)">Δ</b-button>
			</template>
			<template v-else v-slot:cell(Update)>Δ</template>
			<template v-if="$keycloak.hasRealmRole('editTrainer')" v-slot:cell(Delete)="data">
				<b-button variant="btn" @click="deleteTrainer(data.item.id_trainer)">-</b-button>
			</template>
			<template v-else v-slot:cell(Delete)>-</template>
			</b-table>
			<b-pagination
			class="pagination"
			v-model="currentPage"
			:total-rows="rows"
			:per-page="perPage"
			></b-pagination>
		</b-col>
	</b-row>
	<div v-if="$keycloak.hasRealmRole('editTrainer')" class="row" >
        <button class="btn" v-on:click="addTrainer()">Добавить</button>
    </div>
  </div>
</template>

<script>
import TrainerDataService from "../service/DataService";
import MainHeader from "@/components/MainHeader";

export default {
  name: "Trainers",
  components: {MainHeader},
  data() {
    return {
      fields: [
		//{key: 'id_trainer', label: "ИД"}, 
		{key: 'last_name', label: "Фамилия"/*, sortable: true, sortDirection: 'desc'*/ },
		{key: 'first_name', label: "Имя"}, 
		{key:"middle_name", label: "Отчество"},
		{key:"phone", label: "Телефон"},
		{key:"birthday", label: "Дата рождения"},
		{key:"Update",label: "Update"},
		{key:"Delete", label: "Delete"}],           	  
      trainers: [],
      filter: "",
      message: "",
      perPage: 5,
      currentPage: 1,	
    };
  },
  methods: {
    refreshTrainers() {
      TrainerDataService.retrieveAllTrainers().then((res) => {
        this.trainers = res.data;
      });
    },
    addTrainer() {
      this.$router.push(`/trainers/-1`);
    },
    updateTrainer(id_trainer) {
      this.$router.push(`/trainers/${id_trainer}`);
    },
    deleteTrainer(id_trainer) {
      TrainerDataService.deleteTrainer(id_trainer).then(() => {
        this.refreshTrainers();
      });
    },
  },
  computed: {
      rows() {
        return this.trainers.length
      }
  },
  created() {
    this.refreshTrainers();
  },
};
</script>

<!--<template>
  <div class="container">
  <main-header/>
    <h3>Данные о тренерах</h3>
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
			<th>Обновить</th>
			<th>Удалить</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="trainer in trainers" v-bind:key="trainer.id_trainer">          
            <td>{{ trainer.last_name }}</td>
			<td>{{ trainer.first_name }}</td>
			<td>{{ trainer.middle_name }}</td>
            <td>{{ trainer.phone }}</td>
            <td>{{ trainer.birthday }}</td>
			<td>
              <button class="btn" v-on:click="updateTrainer(trainer.id_trainer)">
                Update
              </button>
            </td>
            <td>
              <button class="btn" v-on:click="deleteTrainer(trainer.id_trainer)">
                Delete
              </button>
            </td>
          </tr>
        </tbody>
      </table>
        <div class="row">
        <button class="btn" v-on:click="addTrainer()">Добавить</button>
      </div>
    </div>
  </div>
</template>
<script>
import TrainerDataService from "../service/DataService";
import MainHeader from "@/components/MainHeader";

export default {
  name: "Trainers",
  components: {MainHeader},
  data() {
    return {
      trainers: [],
      message: "",
    };
  },
  methods: {
    refreshTrainers() {
      TrainerDataService.retrieveAllTrainers().then((res) => {
        this.trainers = res.data;
      });
    },
    addTrainer() {
      this.$router.push(`/trainers/-1`);
    },
    updateTrainer(id_trainer) {
      this.$router.push(`/trainers/${id_trainer}`);
    },
    deleteTrainer(id_trainer) {
      TrainerDataService.deleteTrainer(id_trainer).then(() => {
        this.refreshTrainers();
      });
    },
  },
  created() {
    this.refreshTrainers();
  },
};
</script>-->
