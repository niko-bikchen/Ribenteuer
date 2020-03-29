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
    validators: {
      email: [value => /^\w+@\w+\.\w+$/.test(value) || 'Field must containa a valid email'],
      notEmpty: [value => value !== '' || 'Field cannot be empty'],
      passwordNew: [value => value.length >= 10 || 'Pasword should be at least 10 symbols long'],
      nickname: [
        value => value !== '' || 'Nickname cannot be empty',
        value => /^\w+$/.test(value) || 'Nickname can contain only letters, numberts and undersores'
      ],
      characterName: [
        value => value !== '' || 'Character name cannot be empty',
        value =>
          /^\w+$/.test(value) || 'Character name can contain only letters, numbers and underscores'
      ]
    },
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
