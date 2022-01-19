<template>
  <div class="container">
  <main-header/>
    <h3>Данные о секциях</h3>
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
			:items="sections"
			:per-page="perPage"
			:current-page="currentPage"
			:filter="filter"
			:fields="fields">
			<template v-if="$keycloak.hasRealmRole('editSection')" v-slot:cell(Update)="data">
				<b-button variant="btn" @click="updateSection(data.item[0].id_section)">Δ</b-button>
			</template>
			<template v-else v-slot:cell(Update)>Нет прав</template>
			<template v-if="$keycloak.hasRealmRole('editSection')" v-slot:cell(Delete)="data">
				<b-button variant="btn" @click="deleteSection(data.item[0].id_section)">-</b-button>
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
	<div v-if="$keycloak.hasRealmRole('editSection')" class="row">
        <button class="btn" v-on:click="addSection()">Добавить</button>
    </div>
  </div>
</template>

<script>
import SectionDataService from "../service/DataService";
import MainHeader from "@/components/MainHeader";

export default {
  name: "Section",
  components: {MainHeader},
  data() {
    return {
      fields: [
		//{key: '0.id_section', label: "ИД"}, 
		{key: '0.section_name', label: "Наименование секции" },
		//{key: '0.id_trainer', label: "ИД"}, 
		{key: '1.last_name', label: ""}, 
		{key: '1.first_name', label: "Тренер"}, 
		{key: '1.middle_name', label: ""}, 
		{key:"Update",label: "Update"},
		{key:"Delete", label: "Delete"}],           	  
      sections: [],
      filter: "",
      message: "",
      perPage: 5,
      currentPage: 1,	
    };
  },
  methods: {
    refreshSections() {
      SectionDataService.retrieveAllSections().then((res) => {
        this.sections = res.data;
      });
    },
    addSection() {
      this.$router.push(`/sections/-1`);
    },
    updateSection(id_section) {
      this.$router.push(`/sections/${id_section}`);
    },
    deleteSection(id_section) {
      SectionDataService.deleteSection(id_section).then(() => {
        this.refreshSections();
      });
    },
  },
  computed: {
      rows() {
        return this.sections.length
      }
  },
  created() {
    this.refreshSections();
  },
};
</script>

<!--<template>
  <div class="container">
  <main-header/>
    <h3>Данные о секциях</h3>
    <div v-if="message" class="alert alert-success">{{ this.message }}</div>
    <div class="container">
      <table class="table">
        <thead>
          <tr>           
            <th>Наименование секции</th>
			<th>Тренер</th>
			<th>Обновить</th>
			<th>Удалить</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="section in sections" v-bind:key="section.id_section">          
            <td>{{ section.section_name }}</td>
			<td>{{ section.id_trainer }}</td>
			<td>
              <button class="btn" v-on:click="updateSection(section.id_section)">
                Update
              </button>
            </td>
            <td>
              <button class="btn" v-on:click="deleteSection(section.id_section)">
                Delete
              </button>
            </td>
          </tr>
        </tbody>
      </table>
      <div class="row">
        <button class="btn" v-on:click="addSection()">Добавить</button>
      </div>
    </div>
  </div>
</template>
<script>
import SectionDataService from "../service/DataService";
import MainHeader from "@/components/MainHeader";

export default {
  name: "Sections",
  components: {MainHeader},
  data() {
    return {
      sections: [],
      message: "",
    };
  },
  methods: {
    refreshSections() {
      SectionDataService.retrieveAllSections().then((res) => {
        this.sections = res.data;
      });
    },
    addSection() {
      this.$router.push(`/sections/-1`);
    },
    updateSection(id_section) {
      this.$router.push(`/sections/${id_section}`);
    },
    deleteSection(id_section) {
      SectionDataService.deleteSection(id_section).then(() => {
        this.refreshSections();
      });
    },
  },
  created() {
    this.refreshSections();
  },
};
</script>-->
