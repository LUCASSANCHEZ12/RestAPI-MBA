import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { HomeAdmiComponent } from './pages/home-admi/home-admi.component';
import { HomeStudentComponent } from './pages/home-student/home-student.component';
import { HomeTeacherComponent } from './pages/home-teacher/home-teacher.component';
import { CrudUserComponent } from './pages/crud-user/crud-user.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { AdminProgramasComponent } from './pages/admin-programas/admin-programas.component';
import { AgregarMateriaComponent } from './pages/agregar-materia/agregar-materia.component';
import { CrearProgramaComponent } from './pages/crear-programa/crear-programa.component';
import { CrearCasosEstudioComponent } from './pages/crear-editar-casos-estudio/crear-casos-estudio.component';
import { VerCasosEstudioComponent } from './pages/ver-casos-estudio/ver-casos-estudio.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'homeAdmi', component: HomeAdmiComponent },
  { path: 'homeStudent', component: HomeStudentComponent },
  { path: 'homeTeacher', component: HomeTeacherComponent },
  { path: 'crudUser', component: CrudUserComponent},
  { path: 'profile', component: ProfileComponent},
  {path: 'adminProgramas', component : AdminProgramasComponent},
  {path: 'createProgram', component : CrearProgramaComponent},
  {path: 'createMateria', component : AgregarMateriaComponent},
  {path: 'crearCasosEstudio', component : CrearCasosEstudioComponent},
  {path: 'verCasosEstudio', component: VerCasosEstudioComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
