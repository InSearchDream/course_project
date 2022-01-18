<template>
  <div class="container">
  <main-header/>
    <h3>Места проведения секций</h3>
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
			:items="places"
			:per-page="perPage"
			:current-page="currentPage"
			:filter="filter"
			:fields="fields">
			<template v-if="$keycloak.hasRealmRole('editPlace')" v-slot:cell(Update)="data">
				<b-button variant="btn" @click="updatePlace(data.item.id_place)">Δ</b-button>
			</template>
			<template v-if="$keycloak.hasRealmRole('editPlace')" v-slot:cell(Delete)="data">
				<b-button variant="btn" @click="deletePlace(data.item.id_place)">-</b-button>
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
	<div v-if="$keycloak.hasRealmRole('editPlace')" class="row">
        <button class="btn" v-on:click="addPlace()">Добавить</button>
    </div>
  </div>
</template>

<script>
import PlaceDataService from "../service/DataService";
import MainHeader from "@/components/MainHeader";

export default {
  name: "Places",
  components: {MainHeader},
  data() {
    return {
      fields: [
		//{key: 'id_place', label: "ИД"}, 
		{key: 'place_name', label: "Место проведения"/*, sortable: true, sortDirection: 'desc'*/ },
		{key:"Update",label: "Update"},
		{key:"Delete", label: "Delete"}],
      places: [],		
      filter: "",
      message: "",
      perPage: 5,
      currentPage: 1,	
    };
  },
  methods: {
    refreshPlaces() {
      PlaceDataService.retrieveAllPlaces().then((res) => {
        this.places = res.data;
      });
    },
    addPlace() {
      this.$router.push(`/places/-1`);
    },
    updatePlace(id_place) {
      this.$router.push(`/places/${id_place}`);
    },
    deletePlace(id_place) {
      PlaceDataService.deletePlace(id_place).then(() => {
        this.refreshPlaces();
      });
    },
  },
  computed: {
      rows() {
        return this.places.length
      }
  },
  created() {
    this.refreshPlaces();
  },
};
</script>

<!--<template>
  <div class="container">
    <h3>Места проведения секций</h3>
    <div v-if="message" class="alert alert-success">{{ this.message }}</div>
    <div class="container">
      <table class="table">
        <thead>
          <tr>           
            <th>Место проведения</th>
			<th>Обновить</th>
			<th>Удалить</th>
        </tr>
        </thead>
        <tbody>
          <tr v-for="place in places" v-bind:key="place.id_place">          
            <td>{{ place.place_name }}</td>
			<td>
              <button class="btn" v-on:click="updatePlace(place.id_place)">
                Update
              </button>
            </td>
            <td>
              <button class="btn" v-on:click="deletePlace(place.id_place)">
                Delete
              </button>
            </td>
          </tr>
        </tbody>
      </table>
      <div class="row">
        <button class="btn" v-on:click="addPlace()">Добавить</button>
      </div>
    </div>
  </div>
</template>
<script>
import PlaceDataService from "../service/DataService";

export default {
  name: "Places",
  data() {
    return {
      places: [],
      message: "",
    };
  },
  methods: {
    refreshPlaces() {
      PlaceDataService.retrieveAllPlaces().then((res) => {
        this.places = res.data;
      });
    },
    addPlace() {
      this.$router.push(`/places/-1`);
    },
    updatePlace(id_place) {
      this.$router.push(`/places/${id_place}`);
    },
    deletePlace(id_place) {
      PlaceDataService.deletePlace(id_place).then(() => {
        this.refreshPlaces();
      });
    },
  },
  created() {
    this.refreshPlaces();
  },
};
</script>-->