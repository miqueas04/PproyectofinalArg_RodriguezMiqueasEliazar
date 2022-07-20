import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Experiencia } from 'src/app/model/experiencia';
import { ExperienciaService } from 'src/app/service/experiencia.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {

  
  public experiencias:Experiencia[]=[];
  public editarExperiencia:Experiencia | undefined;
  public borrarExperiencia:Experiencia | undefined;

  constructor(private experienciaService:ExperienciaService, private tokenService : TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.getExperiencias();
    if(this.tokenService.getToken()){
      this.isLogged = true;
     }else{
      this.isLogged = false;
     }
  }
public getExperiencias():void{
  this.experienciaService.getExperiencia().subscribe({
  next:(Response: Experiencia[]) =>{
    this.experiencias=Response;
  },
  error:(error:HttpErrorResponse)=>{
    alert(error.message);
  }

  })


}
public onOpenModal(mode:String, experiencia?: Experiencia):void{
const container=document.getElementById('main-container');
const button=document.createElement('button');
button.style.display='none';
button.setAttribute('data-toggle', 'modal');
if(mode==='add'){
  button.setAttribute('data-target', '#addExperienciaModal');
} else if(mode==='delete'){
  this.borrarExperiencia=experiencia;
  button.setAttribute('data-target','#borrarExperienciaModal');
}else if(mode==='edit'){
  this.editarExperiencia=experiencia;
  button.setAttribute('data-target','#editarExperienciaModal');
}
container?.appendChild(button);
button.click();

}
public onAddExperiencia(addForm: NgForm){
  document.getElementById('add-experiencia-form')?.click();
  this.experienciaService.addExperiencia(addForm.value).subscribe({
    next: (response:Experiencia) =>{
      console.log(response);
      this.getExperiencias();
      addForm.reset();
    },
    error:(error:HttpErrorResponse)=>{
      alert(error.message);
      addForm.reset();
    }
  })
}

public onUpdateExperiencia(experiencia: Experiencia){
  this.editarExperiencia=experiencia;
  document.getElementById('add-experiencia-form')?.click();
  this.experienciaService.editarExperiencia(experiencia).subscribe({
    next: (response:Experiencia) =>{
      console.log(response);
      this.getExperiencias();
    },
    error:(error:HttpErrorResponse)=>{
      alert(error.message);
      
    }
  })
}
public onDeleteExperiencia(idExp: number):void{
  
  this.experienciaService.borrarExperiencia(idExp).subscribe({
    next: (response:void) =>{
      console.log(response);
      this.getExperiencias();
    },
    error:(error:HttpErrorResponse)=>{
      alert(error.message);
      
    }
  })
}
}