<template>
  <div>
    <h3>Добавление ученика</h3>
    <div class="container">
      <form @submit="validateAndSubmit">
        <div v-if="errors.length">
          <div
            class="alert alert-danger"
            v-bind:key="index"
            v-for="(error, index) in errors"
          >
            {{ error }}
          </div>
        </div>
		<fieldset class="form-group">
          <label>Фамилия </label>
          <input type="text" class="form-control" v-model="last_name" />
        </fieldset>
		<fieldset class="form-group">
          <label>Имя </label>
          <input type="text" class="form-control" v-model="first_name" />
        </fieldset>
		<fieldset class="form-group">
          <label>Отчество </label>
          <input type="text" class="form-control" v-model="middle_name" />
        </fieldset>
        <fieldset class="form-group">
          <label>Телефон </label>
          <input type="text" class="form-control" v-model="phone" />
        </fieldset>
        <fieldset class="form-group">
          <label>Дата рождения </label>
          <input type="text" class="form-control" v-model="birthday" />
        </fieldset>
		<fieldset class="form-group">
          <label>Секция </label>
          <input type="text" class="form-control" v-model="id_section" />
        </fieldset>
		<fieldset class="form-group">
          <label>Зачисление </label>
          <input type="text" class="form-control" v-model="enrolled" />
        </fieldset>
        <button class="btn" type="submit">Сохранить</button>
      </form>
    </div>
  </div>
</template>
<script>
import LearnerDataService from "../service/DataService";

export default { // добавление не работает
  name: "Learner",
  data() {
    return {
      last_name: "",
      first_name: "",
      middle_name: "",
      phone: "",
      birthday: "",
      id_section: "",
      enrolled: "",
      errors: [],
    };
  },
  computed: {
    id_learner() {
      return this.$route.params.id_learner;
    },
  },
  methods: {
    refreshLearnerDetails() {
      LearnerDataService.retrieveLearner(this.id_learner).then((res) => {
        this.last_name = res.data.last_name;
		this.first_name = res.data.first_name;
		this.middle_name = res.data.middle_name;
        this.phone = res.data.phone;
        this.birthday = res.data.birthday;
		this.id_section = res.data.id_section;
        this.enrolled = res.data.enrolled;
      });
    },
    validateAndSubmit(e) {
      e.preventDefault();
      this.errors = [];
/*      if (!this.last_name) {
        this.errors.push("Введите фамилию");
      }
      if (!this.first_name) {
        this.errors.push("Введите имя");
      }*/
      if (this.errors.length === 0) {
        if (this.id_learner == -1) {
          LearnerDataService.createLearner({
            last_name: this.last_name,
			first_name: this.first_name,
			middle_name: this.middle_name,
            phone: this.phone,
            birthday: this.birthday,
			id_section: this.id_section,
            enrolled: this.enrolled,
          }).then(() => {
            this.$router.push("/learners");
          });
        } else {
          LearnerDataService.updateLearner(this.id_learner, {
            id_learner: this.id_learner,
            last_name: this.last_name,
			first_name: this.first_name,
			middle_name: this.middle_name,			
            phone: this.phone,
            birthday: this.birthday,
			id_section: this.id_section,
            enrolled: this.enrolled,
          }).then(() => {
            this.$router.push("/learners");
          });
        }
      }
    },
  },
  created() {
    this.refreshLearnerDetails();
  },
};
</script>
