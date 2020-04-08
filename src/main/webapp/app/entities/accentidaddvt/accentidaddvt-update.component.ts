import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IACCENTIDADDVT, ACCENTIDADDVT } from 'app/shared/model/accentidaddvt.model';
import { ACCENTIDADDVTService } from './accentidaddvt.service';
import { IACCENTIDADDF } from 'app/shared/model/accentidaddf.model';
import { ACCENTIDADDFService } from 'app/entities/accentidaddf/accentidaddf.service';

@Component({
  selector: 'jhi-accentidaddvt-update',
  templateUrl: './accentidaddvt-update.component.html'
})
export class ACCENTIDADDVTUpdateComponent implements OnInit {
  isSaving = false;
  accentidaddfs: IACCENTIDADDF[] = [];

  editForm = this.fb.group({
    id: [],
    nUMEROVERSION: [],
    fECHAVERSION: [],
    nIF: [],
    eJERCICIO: [],
    iDTIPO: [],
    iDTIPOREND: [],
    iDUNIP: [],
    iDMUNICIPIO: [],
    iDPROVINCIA: [],
    iDISLA: [],
    lOCAL: [],
    iDESTADOACTIVIDAD: [],
    cNAE: [],
    cODIGOMAP: [],
    cODIGOMEH: [],
    iDENTIDADFK1: []
  });

  constructor(
    protected aCCENTIDADDVTService: ACCENTIDADDVTService,
    protected aCCENTIDADDFService: ACCENTIDADDFService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ aCCENTIDADDVT }) => {
      this.updateForm(aCCENTIDADDVT);

      this.aCCENTIDADDFService.query().subscribe((res: HttpResponse<IACCENTIDADDF[]>) => (this.accentidaddfs = res.body || []));
    });
  }

  updateForm(aCCENTIDADDVT: IACCENTIDADDVT): void {
    this.editForm.patchValue({
      id: aCCENTIDADDVT.id,
      nUMEROVERSION: aCCENTIDADDVT.nUMEROVERSION,
      fECHAVERSION: aCCENTIDADDVT.fECHAVERSION,
      nIF: aCCENTIDADDVT.nIF,
      eJERCICIO: aCCENTIDADDVT.eJERCICIO,
      iDTIPO: aCCENTIDADDVT.iDTIPO,
      iDTIPOREND: aCCENTIDADDVT.iDTIPOREND,
      iDUNIP: aCCENTIDADDVT.iDUNIP,
      iDMUNICIPIO: aCCENTIDADDVT.iDMUNICIPIO,
      iDPROVINCIA: aCCENTIDADDVT.iDPROVINCIA,
      iDISLA: aCCENTIDADDVT.iDISLA,
      lOCAL: aCCENTIDADDVT.lOCAL,
      iDESTADOACTIVIDAD: aCCENTIDADDVT.iDESTADOACTIVIDAD,
      cNAE: aCCENTIDADDVT.cNAE,
      cODIGOMAP: aCCENTIDADDVT.cODIGOMAP,
      cODIGOMEH: aCCENTIDADDVT.cODIGOMEH,
      iDENTIDADFK1: aCCENTIDADDVT.iDENTIDADFK1
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const aCCENTIDADDVT = this.createFromForm();
    if (aCCENTIDADDVT.id !== undefined) {
      this.subscribeToSaveResponse(this.aCCENTIDADDVTService.update(aCCENTIDADDVT));
    } else {
      this.subscribeToSaveResponse(this.aCCENTIDADDVTService.create(aCCENTIDADDVT));
    }
  }

  private createFromForm(): IACCENTIDADDVT {
    return {
      ...new ACCENTIDADDVT(),
      id: this.editForm.get(['id'])!.value,
      nUMEROVERSION: this.editForm.get(['nUMEROVERSION'])!.value,
      fECHAVERSION: this.editForm.get(['fECHAVERSION'])!.value,
      nIF: this.editForm.get(['nIF'])!.value,
      eJERCICIO: this.editForm.get(['eJERCICIO'])!.value,
      iDTIPO: this.editForm.get(['iDTIPO'])!.value,
      iDTIPOREND: this.editForm.get(['iDTIPOREND'])!.value,
      iDUNIP: this.editForm.get(['iDUNIP'])!.value,
      iDMUNICIPIO: this.editForm.get(['iDMUNICIPIO'])!.value,
      iDPROVINCIA: this.editForm.get(['iDPROVINCIA'])!.value,
      iDISLA: this.editForm.get(['iDISLA'])!.value,
      lOCAL: this.editForm.get(['lOCAL'])!.value,
      iDESTADOACTIVIDAD: this.editForm.get(['iDESTADOACTIVIDAD'])!.value,
      cNAE: this.editForm.get(['cNAE'])!.value,
      cODIGOMAP: this.editForm.get(['cODIGOMAP'])!.value,
      cODIGOMEH: this.editForm.get(['cODIGOMEH'])!.value,
      iDENTIDADFK1: this.editForm.get(['iDENTIDADFK1'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IACCENTIDADDVT>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }

  trackById(index: number, item: IACCENTIDADDF): any {
    return item.id;
  }
}
