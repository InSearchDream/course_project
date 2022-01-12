<template>
  <div>
    <h3>Заполнение информации о секции</h3>
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
          <label>Наименование секции </label>
          <input type="text" class="form-control" v-model="section_name" />
        </fieldset>
		<fieldset class="form-group">
          <label>Тренер </label>
          <input type="text" class="form-control" v-model="id_trainer" />
        </fieldset>
        <button class="btn" type="submit">Сохранить</button>
      </form>
    </div>
  </div>
</template>
<script>
import SectionDataService from "../service/DataService";

export default { 
  name: "Section",
  data() {
    return {
      section_name: "",
      id_trainer: "",
      errors: [],
    };
  },
  computed: {
    id_section() {
      return this.$route.params.id_section;
    },
  },
  methods: {
    refreshSectionDetails() {
      SectionDataService.retrieveSection(this.id_section).then((res) => {
        this.section_name = res.data.section_name;
		this.id_trainer = res.data.id_trainer;
      });
    },
    validateAndSubmit(e) {
      e.preventDefault();
      this.errors = [];
/*      if (!this.section_name) {
        this.errors.push("Введите секцию");
      }
      if (!this.id_trainer) {
        this.errors.push("Выберите тренера");
      }*/
      if (this.errors.length === 0) {
        if (this.id_section == -1) {
          SectionDataService.createSection({
            section_name: this.section_name,
			id_trainer: this.id_trainer,
          }).then(() => {
            this.$router.push("/sections");
          });
        } else {
          SectionDataService.updateSection(this.id_section, {
            id_section: this.id_section,
            section_name: this.section_name,
			id_trainer: this.id_trainer,
          }).then(() => {
            this.$router.push("/sections");
          });
        }
      }
    },
  },
  created() {
    this.refreshSectionDetails();
  },
};
</script>
