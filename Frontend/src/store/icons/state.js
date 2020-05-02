import {
  laAsteriskSolid,
  laCheckSolid,
  laEnvelopeSolid,
  laExclamationTriangleSolid,
  laFistRaisedSolid,
  laIdCardSolid,
  laUserCircleSolid,
  laUsersSolid,
  laPenNibSolid,
  laIdCard,
  laPlusSolid,
  laMinusSolid
} from '@quasar/extras/line-awesome';

export default function() {
  return {
    icons: {
      envelopeSolid: laEnvelopeSolid,
      asteriskSolid: laAsteriskSolid,
      idCardSolid: laIdCardSolid,
      checkSolid: laCheckSolid,
      exclamationTriangleSolid: laExclamationTriangleSolid,
      userCircleSolid: laUserCircleSolid,
      usersSolid: laUsersSolid,
      fistRaisedSolid: laFistRaisedSolid,
      penNibSolid: laPenNibSolid,
      idCard: laIdCard,
      plus: laPlusSolid,
      minus: laMinusSolid
    }
  };
}
