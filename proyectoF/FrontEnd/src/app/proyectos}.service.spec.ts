import { TestBed } from '@angular/core/testing';

import { Proyectos}Service } from './proyectos}.service';

describe('Proyectos}Service', () => {
  let service: Proyectos}Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Proyectos}Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
