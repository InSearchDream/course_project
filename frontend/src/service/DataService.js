import axios from 'axios'


const API_URL = 'http://localhost:8080/'


class DataService { // delete и update обновить для всех таблиц так же как Trainer
//Trainer
    retrieveAllTrainers() {
        return axios.get(`${API_URL}/trainers/getTrainers`);
    }

    retrieveTrainer(id_trainer) {
        return axios.get(`${API_URL}/trainers/getTrainerById`, id_trainer);
    }

    deleteTrainer(id_trainer) {

       return axios.delete(`${API_URL}/trainers/${id_trainer}`);
    }

    updateTrainer(id_trainer, trainer) {

        return axios.post(`${API_URL}/trainers/updateTrainer`, trainer);
    }

    createTrainer(trainer) {

        return axios.post(`${API_URL}/trainers/insertTrainer`, trainer);
    }

	
//Learner
    retrieveAllLearners() {
        return axios.get(`${API_URL}/learners/getLearners`);
    }
	
	retrieveEnrolledLearners() {
        return axios.get(`${API_URL}/learners/getEnrolledLearners`);
    }

 /*   retrieveLearner(id_learner) {
        return axios.get(`${API_URL}/learners/getLearnerById`);
    }

    deleteLearner(id_learner) {

       return axios.delete(`${API_URL}/learners/deleteLearner`);
    }

    updateLearner(id_learner, learner) {

        return axios.put(`${API_URL}/learners/updateLearner`, learner);
    }

    createLearner(learner) {

        return axios.post(`${API_URL}/learners/addLearner`, learner);
    }
*/	
//Place
    retrieveAllPlaces() {
        return axios.get(`${API_URL}/places/getPlaces`);
    }

 /*   retrievePlace(id_place) {
        return axios.get(`${API_URL}/places/getPlaceById`);
    }

    deletePlace(id_place) {

       return axios.delete(`${API_URL}/places/deletePlace`);
    }

    updatePlace(id_place, place) {

        return axios.put(`${API_URL}/places/updatePlace`, place);
    }

    createPlace(place) {

        return axios.post(`${API_URL}/places/addPlace`, place);
    }
*/	
//Section
    retrieveAllSections() {
        return axios.get(`${API_URL}/sections/getSections`);
    }

/*    retrieveSection(id_section) {
        return axios.get(`${API_URL}/sections/getSectionById`);
    }

    deleteSection(id_section) {

       return axios.delete(`${API_URL}/sections/deleteSection`);
    }

    updateSection(id_section, section) {

        return axios.put(`${API_URL}/sections/updateSection`, section);
    }

    createSection(section) {

        return axios.post(`${API_URL}/sections/addSection`, section);
    }
*/	
//Schedule
    retrieveAllSchedules() {
        return axios.get(`${API_URL}/schedules/getSchedules`);
    }

 /*   retrieveSchedule(id_schedule) {
        return axios.get(`${API_URL}/schedules/getScheduleById`);
    }

    deleteSchedule(id_schedule) {

       return axios.delete(`${API_URL}/schedules/deleteSchedule`);
    }

    updateSchedule(id_schedule, schedule) {

        return axios.put(`${API_URL}/schedules/updateSchedule`, schedule);
    }

    createSchedule(schedule) {

        return axios.post(`${API_URL}/schedules/addSchedule`, schedule);
    }
*/	
//HeaderSchedule
    retrieveAllHeaderSchedules() {
        return axios.get(`${API_URL}/headerschedules/getHeaderSchedules`);
    }

/*    retrieveHeaderSchedule(id_header_schedule) {
        return axios.get(`${API_URL}/headerschedules/getHeaderScheduleById`);
    }

    deleteHeaderSchedule(id_header_schedule) {

       return axios.delete(`${API_URL}/headerschedules/deleteHeaderSchedule`);
    }

    updateHeaderSchedule(id_header_schedule, headerschedule) {

        return axios.put(`${API_URL}/headerschedules/updateHeaderSchedule`, headerschedule);
    }

    createHeaderSchedule(headerschedule) {

        return axios.post(`${API_URL}/headerschedules/addHeaderSchedule`, headerschedule);
    }*/
   
}

export default new DataService()