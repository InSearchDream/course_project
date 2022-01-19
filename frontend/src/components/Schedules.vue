<template>
  <div class="container">
  <main-header/>
    <h3>Общее расписание</h3>
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
			:items="schedules"
			:per-page="perPage"
			:current-page="currentPage"
			:filter="filter"
			:fields="fields">
			<template v-if="$keycloak.hasRealmRole('editSch')||$keycloak.hasRealmRole('updateSch')" v-slot:cell(Update)="data">
				<b-button variant="btn" @click="updateSchedule(data.item[0].id_schedule)">Δ</b-button>
			</template>
			<template v-else v-slot:cell(Update)>Нет прав</template>
			<template v-if="$keycloak.hasRealmRole('editSch')" v-slot:cell(Delete)="data">
				<b-button variant="btn" @click="deleteSchedule(data.item[0].id_schedule)">-</b-button>
			</template>
			<template v-else v-slot:cell(Delete)>Нет прав</template>
			</b-table>
			<b-pagination
			class="pagination"
			v-model="currentPage"
			:total-rows="rows"
			:per-page="perPage"
			></b-pagination>
		</b-col>
	</b-row>
	<div v-if="$keycloak.hasRealmRole('editSch')" class="row">
        <button class="btn" v-on:click="addSchedule()">Добавить</button>
    </div>
  </div>
</template>

<script>
import ScheduleDataService from "../service/DataService";
import MainHeader from "@/components/MainHeader";

export default {
  name: "Schedules",
  components: {MainHeader},
  data() {
    return {
      fields: [
		//{key: 'id_schedule', label: "ИД"}, 
		{key:"2.header_name", label: "Заголовок"},
		{key:"2.approved", label: ""},
		{key: '3.section_name', label: "Секция"},
		{key: '1.place_name', label: "Место проведения"/*, sortable: true, sortDirection: 'desc'*/ },		
		{key:"0.date", label: "Дата"},
		{key:"0.time_start", label: "Время начала"},
		{key:"0.time_end", label: "Время окончания"},
		{key:"0.cancell", label: "Отмена занятия"},
		{key:"0.note", label: "Примечание"},
		{key:"Update",label: "Update"},
		{key:"Delete", label: "Delete"}],           	  
      schedules: [],
      filter: "",
      message: "",
      perPage: 5,
      currentPage: 1,	
    };
  },
  methods: {
    refreshSchedules() {
      ScheduleDataService.retrieveAllSchedules().then((res) => {
        this.schedules = res.data;
      });
    },
    addSchedule() {
      this.$router.push(`/schedules/-1`);
    },
    updateSchedule(id_schedule) {
      this.$router.push(`/schedules/${id_schedule}`);
    },
    deleteSchedule(id_schedule) {
      ScheduleDataService.deleteSchedule(id_schedule).then(() => {
        this.refreshSchedules();
      });
    },
  },
  computed: {
      rows() {
        return this.schedules.length
      }
  },
  created() {
    this.refreshSchedules();
  },
};
</script>

<!--<template>
  <div class="container">
  <main-header/>
    <h3>Общее расписание</h3>
    <div v-if="message" class="alert alert-success">{{ this.message }}</div>
    <div class="container">
      <table class="table">
        <thead>
          <tr>    
            <th>Место проведения</th>
			<th>Секция</th>
			<th>Заголовок</th>	
			<th>Дата</th>
            <th>Время начала</th>
            <th>Время окончания</th>
			<th>Отмена занятия</th>
            <th>Примечание</th>
			<th>Обновить</th>
			<th>Удалить</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="schedule in schedules" v-bind:key="schedule.id_schedule">          
            <td>{{ schedule.id_place }}</td>
			<td>{{ schedule.id_section }}</td>
			<td>{{ schedule.id_header_schedule }}</td>
            <td>{{ schedule.date }}</td>
            <td>{{ schedule.time_start }}</td>
			<td>{{ schedule.time_end }}</td>
            <td>{{ schedule.cancell }}</td>
            <td>{{ schedule.note }}</td>
			<td>
              <button class="btn" v-on:click="updateSchedule(schedule.id_schedule)">
                Update
              </button>
            </td>
            <td>
              <button class="btn" v-on:click="deleteSchedule(schedule.id_schedule)">
                Delete
              </button>
            </td>
          </tr>
        </tbody>
      </table>
      <div class="row">
        <button class="btn" v-on:click="addSchedule()">Добавить</button>
      </div>
    </div>
  </div>
</template>
<script>
import ScheduleDataService from "../service/DataService";
import MainHeader from "@/components/MainHeader";

export default {
  name: "Schedules",
  components: {MainHeader},
  data() {
    return {
      schedules: [],
      message: "",
    };
  },
  methods: {
    refreshSchedules() {
      ScheduleDataService.retrieveAllSchedules().then((res) => {
        this.schedules = res.data;
      });
    },
    addSchedule() {
      this.$router.push(`/schedules/-1`);
    },
    updateSchedule(id_schedule) {
      this.$router.push(`/schedules/${id_schedule}`);
    },
    deleteSchedule(id_schedule) {
      ScheduleDataService.deleteSchedule(id_schedule).then(() => {
        this.refreshSchedules();
      });
    },
  },
  created() {
    this.refreshSchedules();
  },
};
</script>-->
