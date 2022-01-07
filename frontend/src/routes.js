import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

const router = new Router({
    mode: 'history',
    routes: [	
		{
            path: "/",
            name: "mainForm",
            component: () => import("./components/mainForm"),
        },
        {
            path: "/trainers/getTrainers",
            name: "Trainers",
            component: () => import("./components/Trainers"),
        },
		{
            path: "/learners/getLearners",
            name: "Learners",
            component: () => import("./components/Learners"),
        },
		{
            path: "/sections/getSections",
            name: "Sections",
            component: () => import("./components/Sections"),
        },
		{
            path: "/places/getPlaces",
            name: "Places",
            component: () => import("./components/Places"),
        },
		{
            path: "/schedules/getSchedules",
            name: "Schedules",
            component: () => import("./components/Schedules"),
        },
		{
            path: "/headerschedules/getHeaderSchedules",
            name: "HeaderSchedules",
            component: () => import("./components/HeaderSchedules"),
        },
    ]
});

export default router;
