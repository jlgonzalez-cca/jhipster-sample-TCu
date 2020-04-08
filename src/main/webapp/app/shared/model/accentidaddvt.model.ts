import { IACCENTIDADDF } from 'app/shared/model/accentidaddf.model';

export interface IACCENTIDADDVT {
  id?: number;
  nUMEROVERSION?: number;
  fECHAVERSION?: number;
  nIF?: string;
  eJERCICIO?: number;
  iDTIPO?: string;
  iDTIPOREND?: string;
  iDUNIP?: number;
  iDMUNICIPIO?: number;
  iDPROVINCIA?: number;
  iDISLA?: number;
  lOCAL?: string;
  iDESTADOACTIVIDAD?: number;
  cNAE?: string;
  cODIGOMAP?: string;
  cODIGOMEH?: string;
  aCCENTIDADDFS?: IACCENTIDADDF[];
}

export class ACCENTIDADDVT implements IACCENTIDADDVT {
  constructor(
    public id?: number,
    public nUMEROVERSION?: number,
    public fECHAVERSION?: number,
    public nIF?: string,
    public eJERCICIO?: number,
    public iDTIPO?: string,
    public iDTIPOREND?: string,
    public iDUNIP?: number,
    public iDMUNICIPIO?: number,
    public iDPROVINCIA?: number,
    public iDISLA?: number,
    public lOCAL?: string,
    public iDESTADOACTIVIDAD?: number,
    public cNAE?: string,
    public cODIGOMAP?: string,
    public cODIGOMEH?: string,
    public aCCENTIDADDFS?: IACCENTIDADDF[]
  ) {}
}
