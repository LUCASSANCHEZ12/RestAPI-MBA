import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { HomeAdmiComponent } from './pages/home-admi/home-admi.component';
import { HomeStudentComponent } from './pages/home-student/home-student.component';
import { HomeTeacherComponent } from './pages/home-teacher/home-teacher.component';
import { CrudUserComponent } from './pages/crud-user/crud-user.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'homeAdmi', component: HomeAdmiComponent },
  { path: 'homeStudent', component: HomeStudentComponent },
  { path: 'homeTeacher', component: HomeTeacherComponent },
  { path: 'crudUser', component: CrudUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
