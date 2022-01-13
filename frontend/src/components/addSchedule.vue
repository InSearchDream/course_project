<template>
  <div>
    <h3>Заполнение расписания</h3>
    <div class="container">
      <form @submit="validateAndSubmit">
        <fieldset class="form-group">
          <label>Место проведения* </label>
          <input type="text" class="form-control" v-model="id_place" />
        </fieldset>
		<fieldset class="form-group">
          <label>Секция* </label>
          <input type="text" class="form-control" v-model="id_section" />
        </fieldset>
		<fieldset class="form-group">
          <label>Заголовок* </label>
          <input type="text" class="form-control" v-model="id_header_schedule" />
        </fieldset>
        <fieldset class="form-group">
          <label>Дата* </label>
          <input type="text" class="form-control" v-model="date" />
        </fieldset>
        <fieldset class="form-group">
          <label>Время начала* </label>
          <input type="text" class="form-control" v-model="time_start" />
        </fieldset>
		<fieldset class="form-group">
          <label>Время окончания* </label>
          <input type="text" class="form-control" v-model="time_end" />
        </fieldset>
        <fieldset class="form-group">
          <label>Отмена занятия </label>
          <input type="text" class="form-control" v-model="cancell" />
        </fieldset>
        <fieldset class="form-group">
          <label>Премичание </label>
          <input type="text" class="form-control" v-model="note" />
        </fieldset>
		<div v-if="errors.length">
          <div
            class="alert alert-danger"
            v-bind:key="index"
            v-for="(error, index) in errors"
          >
            {{ error }}
          </div>
        </div>
		<button class="btn" type="submit">Сохранить</button>
      </form>
      <div class="row">
        <button class="btn" v-on:click="cansell()">Отмена</button>
      </div>
    </div>
  </div>
</template>
<script>
import ScheduleDataService from "../service/DataService";

export default { 
  name: "Schedule",
  data() {
    return {
      id_place: "",
      id_section: "",
      id_header_schedule: "",
      date: "",
      time_start: "",
      time_end: "",
      cancell: "",
      note: "",
      errors: [],
    };
  },
  computed: {
    id_schedule() {
      return this.$route.params.id_schedule;
    },
  },
  methods: {
	cansell(){
		this.$router.push("/schedules");
	},
    refreshScheduleDetails() {
      ScheduleDataService.retrieveSchedule(this.id_schedule).then((res) => {
        this.id_place = res.data.id_place;
		this.id_section = res.data.id_section;
		this.id_header_schedule = res.data.id_header_schedule;
        this.date = res.data.date;
        this.time_start = res.data.time_start;
		this.time_end = res.data.time_end;
        this.cancell = res.data.cancell;
        this.note = res.data.note;
      });
    },
    validateAndSubmit(e) {
      e.preventDefault();
      this.errors = [];
/*    if ((!this.id_place)||(!this.id_section)||(!this.id_header_schedule)||(!this.date)||(!this.time_start)||(!this.time_end)) {
        this.errors.push("Заполните обязательные поля (*)"); 
      }*/
      if (this.errors.length === 0) {
        if (this.id_schedule == -1) {
          ScheduleDataService.createSchedule({
            id_place: this.id_place,
			id_section: this.id_section,
			id_header_schedule: this.id_header_schedule,
            date: this.date,
            time_start: this.time_start,
			time_end: this.time_end,
            cancell: this.cancell,
            note: this.note,
          }).then(() => {
            this.$router.push("/schedules");
          });
        } else {
          ScheduleDataService.updateSchedule(this.id_schedule, {
            id_schedule: this.id_schedule,
            id_place: this.id_place,
			id_section: this.id_section,
			id_header_schedule: this.id_header_schedule,			
            date: this.date,
            time_start: this.time_start,
			time_end: this.time_end,
            cancell: this.cancell,
            note: this.note,
          }).then(() => {
            this.$router.push("/schedules");
          });
        }
      }
    },
  },
  created() {
    this.refreshScheduleDetails();
  },
};
</script>
