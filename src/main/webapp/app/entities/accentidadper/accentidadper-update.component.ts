import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IACCENTIDADPER, ACCENTIDADPER } from 'app/shared/model/accentidadper.model';
import { ACCENTIDADPERService } from './accentidadper.service';
import { IACCENTIDADDF } from 'app/shared/model/accentidaddf.model';
import { ACCENTIDADDFService } from 'app/entities/accentidaddf/accentidaddf.service';
import { IDCCCARGOENT } from 'app/shared/model/dcccargoent.model';
import { DCCCARGOENTService } from 'app/entities/dcccargoent/dcccargoent.service';

type SelectableEntity = IACCENTIDADDF | IDCCCARGOENT;

@Component({
  selector: 'jhi-accentidadper-update',
  templateUrl: './accentidadper-update.component.html'
})
export class ACCENTIDADPERUpdateComponent implements OnInit {
  isSaving = false;
  accentidaddfs: IACCENTIDADDF[] = [];
  dcccargoents: IDCCCARGOENT[] = [];

  editForm = this.fb.group({
    id: [],
    nIF: [],
    nOMBRE: [],
    aPELLIDO1: [],
    aPELLIDO2: [],
    eMAIL: [],
    iDENTIDADFK2: [],
    iDCARGOFK3: []
  });

  constructor(
    protected aCCENTIDADPERService: ACCENTIDADPERService,
    protected aCCENTIDADDFService: ACCENTIDADDFService,
    protected dCCCARGOENTService: DCCCARGOENTService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ aCCENTIDADPER }) => {
      this.updateForm(aCCENTIDADPER);

      this.aCCENTIDADDFService.query().subscribe((res: HttpResponse<IACCENTIDADDF[]>) => (this.accentidaddfs = res.body || []));

      this.dCCCARGOENTService.query().subscribe((res: HttpResponse<IDCCCARGOENT[]>) => (this.dcccargoents = res.body || []));
    });
  }

  updateForm(aCCENTIDADPER: IACCENTIDADPER): void {
    this.editForm.patchValue({
      id: aCCENTIDADPER.id,
      nIF: aCCENTIDADPER.nIF,
      nOMBRE: aCCENTIDADPER.nOMBRE,
      aPELLIDO1: aCCENTIDADPER.aPELLIDO1,
      aPELLIDO2: aCCENTIDADPER.aPELLIDO2,
      eMAIL: aCCENTIDADPER.eMAIL,
      iDENTIDADFK2: aCCENTIDADPER.iDENTIDADFK2,
      iDCARGOFK3: aCCENTIDADPER.iDCARGOFK3
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const aCCENTIDADPER = this.createFromForm();
    if (aCCENTIDADPER.id !== undefined) {
      this.subscribeToSaveResponse(this.aCCENTIDADPERService.update(aCCENTIDADPER));
    } else {
      this.subscribeToSaveResponse(this.aCCENTIDADPERService.create(aCCENTIDADPER));
    }
  }

  private createFromForm(): IACCENTIDADPER {
    return {
      ...new ACCENTIDADPER(),
      id: this.editForm.get(['id'])!.value,
      nIF: this.editForm.get(['nIF'])!.value,
      nOMBRE: this.editForm.get(['nOMBRE'])!.value,
      aPELLIDO1: this.editForm.get(['aPELLIDO1'])!.value,
      aPELLIDO2: this.editForm.get(['aPELLIDO2'])!.value,
      eMAIL: this.editForm.get(['eMAIL'])!.value,
      iDENTIDADFK2: this.editForm.get(['iDENTIDADFK2'])!.value,
      iDCARGOFK3: this.editForm.get(['iDCARGOFK3'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IACCENTIDADPER>>): void {
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

  trackById(index: number, item: SelectableEntity): any {
    return item.id;
  }
}
