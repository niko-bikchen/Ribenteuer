import { laEnvelopeSolid, laAsteriskSolid, laIdCardSolid } from '@quasar/extras/line-awesome';

export default function() {
  return {
    validators: {
      email: [value => /^\w+@\w+\.\w+$/.test(value) || 'Field must containa a valid email'],
      notEmpty: [value => value !== '' || 'Field cannot be empty'],
      passwordNew: [value => value.length >= 10 || 'Pasword should be at least 10 symbols long'],
      nickname: [
        value => value !== '' || 'Nickname cannot be empty',
        value => /^\w+$/.test(value) || 'Nickname can contain only letters, numberts and undersores'
      ]
    },
    icons: {
      envelopeSolid: laEnvelopeSolid,
      asteriskSolid: laAsteriskSolid,
      idCardSolid: laIdCardSolid
    },
    user: {
      isAuthenticated: false
    }
  };
}
