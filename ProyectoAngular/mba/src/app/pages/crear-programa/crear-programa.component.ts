import { Component, ElementRef, ViewChild } from '@angular/core';
import { AdminProgramasService } from '../../services/admin-programas.service';
import { Materia } from '../../interfaces/materia';
import { AdminProgramas } from '../../interfaces/program';
import { Callback } from '../../interfaces/callback';
import { Router } from '@angular/router';

@Component({
  selector: 'app-crear-programa',
  templateUrl: './crear-programa.component.html',
  styleUrl: './crear-programa.component.css'
})
export class CrearProgramaComponent {
  public codigo: string; 
  public nombre: string;
  public descripcion: string;
  @ViewChild('codeInput')
  codeInput!: ElementRef<HTMLInputElement>; 
  @ViewChild('nameInput')
  nameInput!: ElementRef<HTMLInputElement>;
  @ViewChild('descInput')
  descInput!: ElementRef<HTMLInputElement>;  
  public materiasDisponibles: Materia[] = [];
  public recibirmaterias: Materia[] = [];
  public materiasSeleccionadas: Materia[] = [];
  public programa: AdminProgramas = {
    codigoPrograma: '12',
    nombre: '',
    descripcion: '',
  };
  
  constructor(private programService: AdminProgramasService, private router: Router){
    this.codigo = '';
    this.nombre = '';
    this.descripcion = '';
    this.materiasDisponibles = this.obtenerMateriasDisponibles();
    console.log(this.materiasDisponibles);
  }

  get selectedMaterias(): any[]{
    this.materiasSeleccionadas = this.materiasDisponibles.filter((e,i) => this.materiasSeleccionadas[i]);
    return this.materiasDisponibles.filter((e,i) => this.materiasSeleccionadas[i]);
  }

  click() {
    this.codigo = this.codeInput.nativeElement.value;
    this.nombre = this.nameInput.nativeElement.value;
    this.descripcion = this.descInput.nativeElement.value;
    console.log("Materias seleccionadas:",this.materiasSeleccionadas);
    if (this.codigo !== '' && this.nombre !== '' && this.descripcion !== '') {
      this.crearPrograma(() => {
        this.asingMateria();  
      });  
    } else {
      alert('Llena todos los campos por favor');
    }
  }

  crearProgramaData(){
    const programaData = {
        codigoPrograma:this.codigo,
        nombre: this.nombre,
        descripcion: this.descripcion,
    };

    return programaData
  
  }

  obtenerMateriasDisponibles(){
    console.log('entré');
    this.programService.getMaterias()
      .subscribe((materia: Materia []| null) => {
        if (materia === null) {
          alert('No se recibieron las materias');
        }
        else {
          this.materiasDisponibles = materia;
          console.log(materia);
        }
      });
      return this.materiasDisponibles
  }
  
  crearPrograma(callback: Callback){
    console.log('entré');
    this.programService.createProgram(this.crearProgramaData())
      .subscribe((program: AdminProgramas | null) => {
        if (program === null) {
          alert('No se pudo crear el programa');
        }
        else {
          this.programa = program;
          this.programa.codigoPrograma = program.codigoPrograma;
          console.log(program.codigoPrograma);
          console.log(this.programa.codigoPrograma);
        }
        callback(); 
      });
      return this.programa
  }

  asingMateria(){
    console.log('entré');
    this.programService.addMaterias(this.programa.codigoPrograma , this.materiasSeleccionadas)
      .subscribe((materia: Materia[] | null) => {
        if (materia === null) {
          alert('No se pudo agregar las materias');
        }
        else {
          this.recibirmaterias = materia;
          console.log(this.recibirmaterias);
        }
      });
      return this.recibirmaterias
  }
}
